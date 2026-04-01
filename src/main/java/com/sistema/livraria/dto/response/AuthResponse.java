package com.sistema.livraria.dto.response;

public record AuthResponse(
        String token,
        String tipo,
        String nome,
        String email
) {
    public AuthResponse(String token, String nome, String email) {
        this(token, "Bearer", nome, email);
    }
}