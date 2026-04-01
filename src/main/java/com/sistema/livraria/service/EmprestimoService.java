package com.sistema.livraria.service;

import com.sistema.livraria.dto.request.CreateEmprestimoRequest;
import com.sistema.livraria.dto.response.EmprestimoResponse;
import java.util.List;

public interface EmprestimoService {
    EmprestimoResponse realizar(CreateEmprestimoRequest request, Long usuarioId);
    EmprestimoResponse devolver(Long emprestimoId, Long usuarioId);
    List<EmprestimoResponse> listarPorUsuario(Long usuarioId);
    List<EmprestimoResponse> listarAtrasados();
}