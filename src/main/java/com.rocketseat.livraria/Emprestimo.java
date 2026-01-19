package com.rocketseat.livraria;

import java.time.LocalDateTime;

public class Emprestimo {
    private Long id;
    private Livro livro;
    private String nomeCliente;
    private LocalDateTime dataEmprestimo;
    private LocalDateTime dataDevolucao;

    public Emprestimo(Long id, Livro livro, String nomeCliente) {
        this.id = id;
        this.livro = livro;
        this.nomeCliente = nomeCliente;
        this.dataEmprestimo = LocalDateTime.now();
        this.dataDevolucao = null;
    }

    public Long getId() {
        return id;
    }

    public Livro getLivro() {
        return livro;
    }

    public String getNomeCliente() {
        return nomeCliente;
    }

    public LocalDateTime getDataEmprestimo() {
        return dataEmprestimo;
    }

    public LocalDateTime getDataDevolucao() {
        return dataDevolucao;
    }

    public void setDataDevolucao(LocalDateTime dataDevolucao) {
        this.dataDevolucao = dataDevolucao;
    }

    @Override
    public String toString() {
        return String.format("Empréstimo ID: %d | Livro: %s | Cliente: %s | Data: %s",
                id, livro.getTitulo(), nomeCliente, dataEmprestimo);
    }
}
