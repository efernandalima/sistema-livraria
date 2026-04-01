package com.sistema.livraria.dto.response;

import com.sistema.livraria.domain.enums.StatusEmprestimo;
import java.time.LocalDate;
import java.time.LocalDateTime;

public record EmprestimoResponse(
        Long id,
        String tituloLivro,
        String nomeUsuario,
        LocalDate dataEmprestimo,
        LocalDate dataDevolucao,
        StatusEmprestimo status,
        LocalDateTime createdAt
) {}