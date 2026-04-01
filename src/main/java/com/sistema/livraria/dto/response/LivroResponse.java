package com.sistema.livraria.dto.response;

import com.sistema.livraria.domain.enums.StatusLivro;
import java.time.LocalDateTime;

public record LivroResponse(
        Long id,
        String titulo,
        String isbn,
        StatusLivro status,
        String autorNome,
        LocalDateTime createdAt
) {}