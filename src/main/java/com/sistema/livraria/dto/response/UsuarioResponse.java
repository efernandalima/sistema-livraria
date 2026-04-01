package com.sistema.livraria.dto.response;

import com.sistema.livraria.domain.enums.RoleUsuario;
import java.time.LocalDateTime;

public record UsuarioResponse(
        Long id,
        String nome,
        String email,
        RoleUsuario role,
        LocalDateTime createdAt
) {}