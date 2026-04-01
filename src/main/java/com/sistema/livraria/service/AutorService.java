package com.sistema.livraria.service;

import com.sistema.livraria.dto.request.CreateAutorRequest;
import com.sistema.livraria.dto.response.AutorResponse;
import java.util.List;

public interface AutorService {
    AutorResponse criar(CreateAutorRequest request);
    AutorResponse buscarPorId(Long id);
    List<AutorResponse> listarTodos();
    void deletar(Long id);
}