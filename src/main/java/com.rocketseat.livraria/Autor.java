package com.rocketseat.livraria;

import java.time.LocalDate;

public class Autor {
    private Long id;
    private String nome;
    private LocalDate dataNascimento;

    public Autor(Long id, String nome, LocalDate dataNascimento) {
        this.id = id;
        this.nome = nome;
        this.dataNascimento = dataNascimento;
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    @Override
    public String toString() {
        return nome;
    }
}
