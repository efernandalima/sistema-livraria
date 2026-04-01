package com.sistema.livraria.dto.request;

import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotNull;
import java.time.LocalDate;

public record CreateEmprestimoRequest(

        @NotNull(message = "Livro é obrigatório")
        Long livroId,

        @NotNull(message = "Data de devolução é obrigatória")
        @Future(message = "Data de devolução deve ser no futuro")
        LocalDate dataDevolucao
) {}