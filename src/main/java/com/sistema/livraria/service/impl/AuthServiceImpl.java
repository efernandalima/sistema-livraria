package com.sistema.livraria.service.impl;

import com.sistema.livraria.dto.request.LoginRequest;
import com.sistema.livraria.dto.request.RegisterRequest;
import com.sistema.livraria.dto.response.AuthResponse;
import com.sistema.livraria.dto.response.UsuarioResponse;
import com.sistema.livraria.exception.EmailAlreadyExistsException;
import com.sistema.livraria.mapper.UsuarioMapper;
import com.sistema.livraria.repository.UsuarioRepository;
import com.sistema.livraria.security.JwtService;
import com.sistema.livraria.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {

    private final UsuarioRepository usuarioRepository;
    private final UsuarioMapper usuarioMapper;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;

    @Override
    @Transactional
    public UsuarioResponse register(RegisterRequest request) {
        if (usuarioRepository.existsByEmail(request.email())) {
            throw new EmailAlreadyExistsException(request.email());
        }

        var usuario = usuarioMapper.toEntity(request);
        usuario.setSenha(passwordEncoder.encode(request.senha()));

        return usuarioMapper.toResponse(usuarioRepository.save(usuario));
    }

    @Override
    public AuthResponse login(LoginRequest request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(request.email(), request.senha())
        );

        var usuario = usuarioRepository.findByEmail(request.email()).orElseThrow();
        var userDetails = org.springframework.security.core.userdetails.User
                .withUsername(usuario.getEmail())
                .password(usuario.getSenha())
                .roles(usuario.getRole().name())
                .build();

        var token = jwtService.gerarToken(userDetails);
        return new AuthResponse(token, usuario.getNome(), usuario.getEmail());
    }
}