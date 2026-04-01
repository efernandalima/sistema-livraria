package com.sistema.livraria.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record CreateLivroRequest(

        @NotBlank(message = "Título é obrigatório")
        @Size(min = 1, max = 200, message = "Título deve ter entre 1 e 200 caracteres")
        String titulo,

        @NotBlank(message = "ISBN é obrigatório")
        @Size(min = 10, max = 20, message = "ISBN inválido")
        String isbn,

        @NotNull(message = "Autor é obrigatório")
        Long autorId
) {}