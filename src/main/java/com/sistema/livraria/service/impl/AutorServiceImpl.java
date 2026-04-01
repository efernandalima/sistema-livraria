package com.sistema.livraria.service.impl;

import com.sistema.livraria.dto.request.CreateAutorRequest;
import com.sistema.livraria.dto.response.AutorResponse;
import com.sistema.livraria.exception.BusinessException;
import com.sistema.livraria.exception.ResourceNotFoundException;
import com.sistema.livraria.mapper.AutorMapper;
import com.sistema.livraria.repository.AutorRepository;
import com.sistema.livraria.service.AutorService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
@RequiredArgsConstructor
public class AutorServiceImpl implements AutorService {

    private final AutorRepository autorRepository;
    private final AutorMapper autorMapper;

    @Override
    @Transactional
    public AutorResponse criar(CreateAutorRequest request) {
        if (autorRepository.existsByNomeIgnoreCase(request.nome())) {
            throw new BusinessException("Autor '%s' já cadastrado".formatted(request.nome()));
        }
        var autor = autorMapper.toEntity(request);
        return autorMapper.toResponse(autorRepository.save(autor));
    }

    @Override
    @Transactional(readOnly = true)
    public AutorResponse buscarPorId(Long id) {
        return autorRepository.findById(id)
                .map(autorMapper::toResponse)
                .orElseThrow(() -> new ResourceNotFoundException("Autor", id));
    }

    @Override
    @Transactional(readOnly = true)
    public List<AutorResponse> listarTodos() {
        return autorRepository.findAll()
                .stream()
                .map(autorMapper::toResponse)
                .toList();
    }

    @Override
    @Transactional
    public void deletar(Long id) {
        if (!autorRepository.existsById(id)) {
            throw new ResourceNotFoundException("Autor", id);
        }
        autorRepository.deleteById(id);
    }
}