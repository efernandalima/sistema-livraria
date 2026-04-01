package com.sistema.livraria.service.impl;

import com.sistema.livraria.domain.enums.StatusLivro;
import com.sistema.livraria.dto.request.CreateLivroRequest;
import com.sistema.livraria.dto.response.LivroResponse;
import com.sistema.livraria.exception.BusinessException;
import com.sistema.livraria.exception.ResourceNotFoundException;
import com.sistema.livraria.mapper.LivroMapper;
import com.sistema.livraria.repository.AutorRepository;
import com.sistema.livraria.repository.LivroRepository;
import com.sistema.livraria.service.LivroService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
@RequiredArgsConstructor
public class LivroServiceImpl implements LivroService {

    private final LivroRepository livroRepository;
    private final AutorRepository autorRepository;
    private final LivroMapper livroMapper;

    @Override
    @Transactional
    public LivroResponse criar(CreateLivroRequest request) {
        if (livroRepository.existsByIsbn(request.isbn())) {
            throw new BusinessException("ISBN '%s' já cadastrado".formatted(request.isbn()));
        }

        var autor = autorRepository.findById(request.autorId())
                .orElseThrow(() -> new ResourceNotFoundException("Autor", request.autorId()));

        var livro = livroMapper.toEntity(request);
        livro.setAutor(autor);
        livro.setStatus(StatusLivro.DISPONIVEL);

        return livroMapper.toResponse(livroRepository.save(livro));
    }

    @Override
    @Transactional(readOnly = true)
    public LivroResponse buscarPorId(Long id) {
        return livroRepository.findById(id)
                .map(livroMapper::toResponse)
                .orElseThrow(() -> new ResourceNotFoundException("Livro", id));
    }

    @Override
    @Transactional(readOnly = true)
    public List<LivroResponse> listarTodos() {
        return livroRepository.findAll()
                .stream()
                .map(livroMapper::toResponse)
                .toList();
    }

    @Override
    @Transactional(readOnly = true)
    public List<LivroResponse> listarDisponiveis() {
        return livroRepository.findByStatus(StatusLivro.DISPONIVEL)
                .stream()
                .map(livroMapper::toResponse)
                .toList();
    }

    @Override
    @Transactional
    public void deletar(Long id) {
        if (!livroRepository.existsById(id)) {
            throw new ResourceNotFoundException("Livro", id);
        }
        livroRepository.deleteById(id);
    }
}