package com.rocketseat.livraria;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Biblioteca {
    private List<Livro> livros = new ArrayList<Livro>();
    private List<Autor>  autores = new ArrayList<>();
    private List<Emprestimo> emprestimos = new ArrayList<>();
    private Long proximoIdEmprestimo = 1L;

    public Biblioteca(){
        inicializarDados();
    }
    private void inicializarDados(){
        // Criando autores
        Autor machado = new Autor(1L, "Machado de Assis", LocalDate.of(1839, 6, 21));
        Autor clarice = new Autor(2L, "Clarice Lispector", LocalDate.of(1920, 12, 10));
        Autor jorge = new Autor(3L, "Jorge Amado", LocalDate.of(1912, 8, 10));
        Autor cecilia = new Autor(4L, "Cecília Meireles", LocalDate.of(1901, 11, 7));
        Autor paulo = new Autor(5L, "Paulo Coelho", LocalDate.of(1947, 8, 24));

        autores.add(machado);
        autores.add(clarice);
        autores.add(jorge);
        autores.add(cecilia);
        autores.add(paulo);

        // Criando livros
        livros.add(new Livro(1L, "Dom Casmurro", machado));
        livros.add(new Livro(2L, "Memórias Póstumas de Brás Cubas", machado));
        livros.add(new Livro(3L, "A Hora da Estrela", clarice));
        livros.add(new Livro(4L, "A Paixão Segundo G.H.", clarice));
        livros.add(new Livro(5L, "Capitães da Areia", jorge));
        livros.add(new Livro(6L, "Gabriela, Cravo e Canela", jorge));
        livros.add(new Livro(7L, "Romanceiro da Inconfidência", cecilia));
        livros.add(new Livro(8L, "O Alquimista", paulo));
        livros.add(new Livro(9L, "Brida", paulo));
        livros.add(new Livro(10L, "Veronika Decide Morrer", paulo));
    }
    public void listarLivrosDisponiveis(){
        System.out.println("\n" + "=".repeat(70));
        System.out.println("LIVROS DISPONÍVEIS PARA EMPRÉSTIMO");
        System.out.println("=".repeat(70));

        boolean temDisponiveis = false;
        for (Livro livro : livros) {
            if (livro.isDisponivel()) {
                System.out.println(livro);
                temDisponiveis = true;
            }
        }

        if (!temDisponiveis) {
            System.out.println("Nenhum livro disponível no momento.");
        }

        System.out.println("=".repeat(70) + "\n");
    }

    private Livro buscarLivroPorId(Long id) {
        for (Livro livro : livros) {
            if (livro.getId().equals(id)) {
                return livro;
            }
        }
        return null;
    }
    public void realizarEmprestimo(Scanner scanner) {
        System.out.print("\n Digite o ID do livro que deseja emprestar: ");
        Long livroId = scanner.nextLong();
        scanner.nextLine();

        Livro livro = buscarLivroPorId(livroId);

        if (livro == null) {
            System.out.println("Livro não encontrado!");
            return;
        }

        if (!livro.isDisponivel()) {
            System.out.println(" Este livro já está emprestado!");
            return;
        }

        System.out.print("👤 Digite seu nome completo: ");
        String nomeCliente = scanner.nextLine();

        Emprestimo emprestimo = new Emprestimo(proximoIdEmprestimo++, livro, nomeCliente);
        emprestimos.add(emprestimo);

        livro.setDisponivel(false);

        System.out.println("\n" + "=".repeat(70));
        System.out.println(" EMPRÉSTIMO REALIZADO COM SUCESSO!");
        System.out.println("=".repeat(70));
        System.out.println(" Livro: " + livro.getTitulo());
        System.out.println("✍ Autor: " + livro.getAutor().getNome());
        System.out.println(" Cliente: " + nomeCliente);
        System.out.println(" Data: " + emprestimo.getDataEmprestimo().toLocalDate());
        System.out.println(" Hora: " + emprestimo.getDataEmprestimo().toLocalTime());
        System.out.println("=".repeat(70) + "\n");
    }

    public void iniciar() {
        Scanner scanner = new Scanner(System.in);
        boolean continuar = true;

        System.out.println("\n" + "=".repeat(70));
        System.out.println(" BEM-VINDO AO SISTEMA DE BIBLIOTECA ROCKETSEAT");
        System.out.println("=".repeat(70));

        while (continuar) {
            System.out.print("\n Deseja ver a lista de livros disponíveis? (SIM/NAO): ");
            String resposta = scanner.nextLine().trim().toUpperCase();

            if (resposta.equals("SIM") || resposta.equals("S")) {
                listarLivrosDisponiveis();
                realizarEmprestimo(scanner);
            } else if (resposta.equals("NAO") || resposta.equals("NÃO") || resposta.equals("N")) {
                System.out.println("\n" + "=".repeat(70));
                System.out.println(" Obrigado por usar o Sistema de Biblioteca Rocketseat!");
                System.out.println("Até a próxima visita!");
                System.out.println("=".repeat(70) + "\n");
                continuar = false;
            } else {
                System.out.println("  Resposta inválida! Digite SIM ou NAO.");
            }
        }

        scanner.close();
    }

    public static void main(String[] args) {
        Biblioteca biblioteca = new Biblioteca();
        biblioteca.iniciar();
    }
}

