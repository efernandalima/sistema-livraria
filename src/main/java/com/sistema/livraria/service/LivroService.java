package com.sistema.livraria.service;

import com.sistema.livraria.dto.request.CreateLivroRequest;
import com.sistema.livraria.dto.response.LivroResponse;
import java.util.List;

public interface LivroService {
    LivroResponse criar(CreateLivroRequest request);
    LivroResponse buscarPorId(Long id);
    List<LivroResponse> listarTodos();
    List<LivroResponse> listarDisponiveis();
    void deletar(Long id);
}