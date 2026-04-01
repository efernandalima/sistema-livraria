package com.sistema.livraria.service.impl;

import com.sistema.livraria.domain.enums.StatusEmprestimo;
import com.sistema.livraria.domain.enums.StatusLivro;
import com.sistema.livraria.dto.request.CreateEmprestimoRequest;
import com.sistema.livraria.dto.response.EmprestimoResponse;
import com.sistema.livraria.exception.BusinessException;
import com.sistema.livraria.exception.ResourceNotFoundException;
import com.sistema.livraria.mapper.EmprestimoMapper;
import com.sistema.livraria.repository.EmprestimoRepository;
import com.sistema.livraria.repository.LivroRepository;
import com.sistema.livraria.repository.UsuarioRepository;
import com.sistema.livraria.service.EmprestimoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class EmprestimoServiceImpl implements EmprestimoService {

    private final EmprestimoRepository emprestimoRepository;
    private final LivroRepository livroRepository;
    private final UsuarioRepository usuarioRepository;
    private final EmprestimoMapper emprestimoMapper;

    @Override
    @Transactional
    public EmprestimoResponse realizar(CreateEmprestimoRequest request, Long usuarioId) {
        var livro = livroRepository.findById(request.livroId())
                .orElseThrow(() -> new ResourceNotFoundException("Livro", request.livroId()));

        if (livro.getStatus() != StatusLivro.DISPONIVEL) {
            throw new BusinessException("Livro '%s' não está disponível para empréstimo"
                    .formatted(livro.getTitulo()));
        }

        var usuario = usuarioRepository.findById(usuarioId)
                .orElseThrow(() -> new ResourceNotFoundException("Usuário", usuarioId));

        livro.setStatus(StatusLivro.EMPRESTADO);
        livroRepository.save(livro);

        var emprestimo = com.sistema.livraria.domain.entity.Emprestimo.builder()
                .livro(livro)
                .usuario(usuario)
                .dataEmprestimo(LocalDate.now())
                .dataDevolucao(request.dataDevolucao())
                .status(StatusEmprestimo.ATIVO)
                .build();

        return emprestimoMapper.toResponse(emprestimoRepository.save(emprestimo));
    }

    @Override
    @Transactional
    public EmprestimoResponse devolver(Long emprestimoId, Long usuarioId) {
        var emprestimo = emprestimoRepository.findById(emprestimoId)
                .orElseThrow(() -> new ResourceNotFoundException("Empréstimo", emprestimoId));

        if (!emprestimo.getUsuario().getId().equals(usuarioId)) {
            throw new BusinessException("Empréstimo não pertence ao usuário informado");
        }

        if (emprestimo.getStatus() == StatusEmprestimo.DEVOLVIDO) {
            throw new BusinessException("Livro já foi devolvido");
        }

        emprestimo.setStatus(StatusEmprestimo.DEVOLVIDO);
        emprestimo.getLivro().setStatus(StatusLivro.DISPONIVEL);

        livroRepository.save(emprestimo.getLivro());
        return emprestimoMapper.toResponse(emprestimoRepository.save(emprestimo));
    }

    @Override
    @Transactional(readOnly = true)
    public List<EmprestimoResponse> listarPorUsuario(Long usuarioId) {
        return emprestimoRepository.findByUsuarioId(usuarioId)
                .stream()
                .map(emprestimoMapper::toResponse)
                .toList();
    }

    @Override
    @Transactional(readOnly = true)
    public List<EmprestimoResponse> listarAtrasados() {
        return emprestimoRepository.findEmprestimosAtrasados(LocalDate.now())
                .stream()
                .map(emprestimoMapper::toResponse)
                .toList();
    }
}