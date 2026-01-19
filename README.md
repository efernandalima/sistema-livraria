# 📚 Sistema de Livraria - Rocketseat

![Java](https://img.shields.io/badge/Java-17-orange?style=for-the-badge&logo=java)
![Maven](https://img.shields.io/badge/Maven-3.8+-red?style=for-the-badge&logo=apache-maven)
![Status](https://img.shields.io/badge/Status-Concluído-success?style=for-the-badge)
![License](https://img.shields.io/badge/License-MIT-blue?style=for-the-badge)

Sistema de gerenciamento de biblioteca desenvolvido em Java, com foco em
**Clean Code**, **POO** e **boas práticas de programação**.

------------------------------------------------------------------------

## 🎯 Sobre o Projeto

Aplicação de console que simula um sistema básico de biblioteca,
permitindo:

-   ✅ Visualizar lista de livros disponíveis
-   ✅ Realizar empréstimos de livros
-   ✅ Controlar status dos livros (disponível/emprestado)
-   ✅ Gerenciar autores e clientes
-   ✅ Validar empréstimos duplicados
-   ✅ Registrar data e hora das operações

Este projeto foi desenvolvido como parte do **Desafio Prático da
Formação Java da Rocketseat**.

------------------------------------------------------------------------

## 🚀 Tecnologias Utilizadas

-   **Java 17+** (compatível até Java 23)
-   **Maven** - Gerenciador de dependências e build
-   **Java Time API** - Manipulação de datas e horários
-   **Collections Framework** - ArrayList para gerenciamento de dados
-   **POO** - Programação Orientada a Objetos
-   **Clean Code** - Código limpo e legível

------------------------------------------------------------------------

## 📋 Funcionalidades

### ✅ Tarefas Implementadas (12/12)

  -----------------------------------------------------------------------
\#          Tarefa                        Status
  ----------- ----------------------------- -----------------------------
1           Criar classe `Autor`          ✅ Concluído

2           Criar classe `Livro`          ✅ Concluído

3           Criar classe `Biblioteca`     ✅ Concluído

4           Inicializar listas (livros,   ✅ Concluído
autores, empréstimos)

5           Adicionar dados hardcoded (5  ✅ Concluído
autores, 10 livros)

6           Implementar loop principal de ✅ Concluído
interação

7           Implementar lógica "NÃO"      ✅ Concluído
(encerramento)

8           Implementar lógica "SIM"      ✅ Concluído
(listar livros disponíveis)

9           Permitir seleção de livro por ✅ Concluído
ID

10          Solicitar nome do usuário     ✅ Concluído

11          Marcar livro como             ✅ Concluído
indisponível ao emprestar

12          Exibir mensagem de sucesso do ✅ Concluído
empréstimo
  -----------------------------------------------------------------------

------------------------------------------------------------------------

## 📦 Estrutura do Projeto

    sistema-livraria/
    ├── src/
    │   └── main/
    │       └── java/
    │           └── com/rocketseat/livraria/
    │               ├── Autor.java
    │               ├── Livro.java
    │               ├── Emprestimo.java
    │               └── Biblioteca.java
    ├── target/
    ├── .gitignore
    ├── pom.xml
    └── README.md

------------------------------------------------------------------------

## 🛠️ Como Executar

### Pré-requisitos

-   **Java JDK 17** ou superior
-   **Maven 3.8+**
-   **IntelliJ IDEA** (ou qualquer IDE Java)

### Opção 1: Via IntelliJ IDEA

1.  Clone o repositório\
2.  Abra o projeto no IntelliJ IDEA\
3.  Aguarde o Maven baixar as dependências\
4.  Execute a classe `Biblioteca.java`

### Opção 2: Via Linha de Comando

``` bash
git clone https://github.com/efernandalima/sistema-livraria.git
cd sistema-livraria
mvn clean compile
mvn exec:java -Dexec.mainClass="com.rocketseat.livraria.Biblioteca"
```

### Opção 3: Gerando JAR

``` bash
mvn clean package
java -jar target/sistema-livraria-1.0.0.jar
```

------------------------------------------------------------------------

## 💡 Como Usar

Ao iniciar, o sistema pergunta:

    Deseja ver a lista de livros disponíveis? (SIM/NAO):

-   Digite **SIM** para visualizar os livros\
-   Digite o **ID** do livro\
-   Informe seu **nome completo**\
-   Confirme o empréstimo ou digite **NAO** para sair

------------------------------------------------------------------------

## 📚 Livros Disponíveis (Padrão)

ID   Título                            Autor
  ---- --------------------------------- -------------------
1    Dom Casmurro                      Machado de Assis
2    Memórias Póstumas de Brás Cubas   Machado de Assis
3    A Hora da Estrela                 Clarice Lispector
4    A Paixão Segundo G.H.             Clarice Lispector
5    Capitães da Areia                 Jorge Amado
6    Gabriela, Cravo e Canela          Jorge Amado
7    Romanceiro da Inconfidência       Cecília Meireles
8    O Alquimista                      Paulo Coelho
9    Brida                             Paulo Coelho
10   Veronika Decide Morrer            Paulo Coelho

------------------------------------------------------------------------

## 🎨 Conceitos Aplicados

### Clean Code

-   Nomes descritivos
-   Métodos pequenos
-   Código legível

### Programação Orientada a Objetos

-   Encapsulamento
-   Abstração
-   Separação de responsabilidades

### Boas Práticas

-   Organização em pacotes
-   Validações de negócio
-   Código reutilizável

------------------------------------------------------------------------

## 🔮 Melhorias Futuras

-   Sistema de devolução
-   Persistência em banco de dados
-   API REST com Spring Boot
-   Interface gráfica
-   Testes unitários

------------------------------------------------------------------------

## 👨‍💻 Autor

**Fernanda Raimundo de Lima**\
GitHub: https://github.com/efernandalima\
LinkedIn: https://www.linkedin.com/in/fernandaliima/

------------------------------------------------------------------------

## 📊 Status do Projeto

**Concluído --- Janeiro/2026**
