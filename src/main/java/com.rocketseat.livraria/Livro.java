package com.rocketseat.livraria;

import java.time.LocalDate;

public class Livro {
 private Long id;
 private String titulo;
 private Autor autor;
 private boolean disponivel;
 private LocalDate dataCadastro;
 private LocalDate dataAtualizacao;
  public Livro( Long id, String titulo, Autor autor){
      this.id = id;
      this.titulo = titulo;
      this.autor = autor;
      this.disponivel = true;
      this.dataCadastro = LocalDate.now();
      this.dataAtualizacao = LocalDate.now();
  }
  public Long getId() {
      return id;
  }
  public String getTitulo() {
      return titulo;
  }
  public Autor getAutor() {
      return autor;
  }
  public boolean isDisponivel() {
      return disponivel;
  }
  public void setDisponivel(boolean disponivel) {
      this.disponivel = disponivel;
      this.dataAtualizacao = LocalDate.now();
  }
  public LocalDate getDataCadastro() {
      return dataCadastro;
  }
  public LocalDate getDataAtualizacao() {
      return dataAtualizacao;
  }
  @Override
  public String toString() {
      return String.format("ID: %d | Título: %s | Autor: %s | Status: %s",
              id, titulo, autor.getNome(), disponivel ? "DISPONÍVEL" : "EMPRESTADO");
  }
}
