package com.sistema.livraria.dto.response;

import java.time.LocalDate;
import java.time.LocalDateTime;

public record AutorResponse(
        Long id,
        String nome,
        LocalDate nascimento,
        LocalDateTime createdAt
) {}