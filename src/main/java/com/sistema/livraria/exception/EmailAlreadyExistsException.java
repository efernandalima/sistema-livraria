package com.sistema.livraria.exception;

public class EmailAlreadyExistsException extends RuntimeException {

    public EmailAlreadyExistsException(String email) {
        super("Email '%s' já está em uso".formatted(email));
    }
}