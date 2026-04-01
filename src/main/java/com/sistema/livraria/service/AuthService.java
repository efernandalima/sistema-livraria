package com.sistema.livraria.service;

import com.sistema.livraria.dto.request.LoginRequest;
import com.sistema.livraria.dto.request.RegisterRequest;
import com.sistema.livraria.dto.response.AuthResponse;
import com.sistema.livraria.dto.response.UsuarioResponse;

public interface AuthService {
    UsuarioResponse register(RegisterRequest request);
    AuthResponse login(LoginRequest request);
}