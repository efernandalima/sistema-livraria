# 📚 Sistema Livraria API

API REST para gerenciamento de livraria, desenvolvida com Java 21 e Spring Boot 3.x.

![Java](https://img.shields.io/badge/Java-21-orange?style=flat&logo=java)
![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.2.4-green?style=flat&logo=springboot)
![PostgreSQL](https://img.shields.io/badge/PostgreSQL-16-blue?style=flat&logo=postgresql)
![Docker](https://img.shields.io/badge/Docker-ready-blue?style=flat&logo=docker)
![JWT](https://img.shields.io/badge/Auth-JWT-black?style=flat&logo=jsonwebtokens)

---

## 🏗️ Arquitetura

Projeto desenvolvido como monólito modular com fronteiras de domínio bem definidas, seguindo os princípios de DDD. Cada módulo é independente e preparado para extração futura como microsserviço autônomo com banco de dados próprio.

```
src/main/java/com/sistema/livraria/
├── config/         → Configurações (Security, OpenAPI)
├── controller/     → Camada REST (endpoints)
├── service/        → Regras de negócio
│   └── impl/
├── repository/     → Acesso ao banco (Spring Data JPA)
├── domain/
│   ├── entity/     → Entidades JPA
│   └── enums/      → Enumerações de domínio
├── dto/
│   ├── request/    → Dados de entrada validados
│   └── response/   → Dados de saída controlados
├── exception/      → Exceções customizadas + Handler global
├── mapper/         → Conversão Entity ↔ DTO (MapStruct)
└── security/       → JWT Filter + UserDetailsService
```

---

## 🚀 Tecnologias

| Tecnologia | Uso |
|---|---|
| Java 21 | Linguagem principal |
| Spring Boot 3.x | Framework |
| Spring Security + JWT | Autenticação stateless |
| Spring Data JPA + Hibernate | Persistência |
| PostgreSQL 16 | Banco de dados |
| Flyway | Versionamento do banco |
| MapStruct | Mapeamento Entity ↔ DTO |
| SpringDoc OpenAPI | Documentação Swagger |
| Docker + Docker Compose | Containerização |
| Lombok | Redução de boilerplate |

---

## 📋 Pré-requisitos

- Java 21+
- Docker Desktop
- Maven 3.8+

---

## ▶️ Como Rodar

**1. Clone o repositório**
```bash
git clone https://github.com/efernandalima/sistema-livraria.git
cd sistema-livraria
```

**2. Suba o banco de dados**
```bash
docker-compose up -d
```

**3. Execute a aplicação**
```bash
./mvnw spring-boot:run
```

**4. Acesse o Swagger**

```
http://localhost:8080/swagger-ui/index.html
```

---

## 🔐 Autenticação

A API usa autenticação **JWT (Bearer Token)**. Para acessar endpoints protegidos:

1. `POST /api/auth/register` → Cria um usuário
2. `POST /api/auth/login` → Obtém o token JWT
3. Clique em **Authorize** no Swagger e insira: `Bearer <token>`

---

## 📡 Endpoints

| Método | Endpoint | Descrição | Auth |
|---|---|---|---|
| POST | `/api/auth/register` | Registrar usuário | ❌ |
| POST | `/api/auth/login` | Login / obter token | ❌ |
| GET | `/api/livros` | Listar livros | ❌ |
| GET | `/api/livros/disponiveis` | Livros disponíveis | ❌ |
| POST | `/api/livros` | Cadastrar livro | ✅ |
| DELETE | `/api/livros/{id}` | Deletar livro | ✅ |
| GET | `/api/autores` | Listar autores | ❌ |
| POST | `/api/autores` | Cadastrar autor | ✅ |
| POST | `/api/emprestimos/usuario/{id}` | Realizar empréstimo | ✅ |
| PATCH | `/api/emprestimos/{id}/devolver/usuario/{uid}` | Devolver livro | ✅ |
| GET | `/api/emprestimos/atrasados` | Empréstimos atrasados | ✅ |

---

## 🔒 Segurança Implementada

- Autenticação stateless com JWT
- Senhas criptografadas com BCrypt
- DTOs de resposta (nunca expõe entidades diretamente)
- Validação de entrada com Bean Validation
- Tratamento global de erros sem expor detalhes internos
- Variáveis sensíveis via variáveis de ambiente

---

## 📁 Variáveis de Ambiente

Crie um arquivo `.env` na raiz **(nunca commitar)**:

```env
DB_USERNAME=postgres
DB_PASSWORD=postgres
JWT_SECRET=sua-chave-secreta-aqui
```

---

## 🗺️ Próximos Passos (Roadmap)

- [ ] Testes unitários com JUnit 5 + Mockito
- [ ] Testes de integração com @SpringBootTest
- [ ] Paginação nos endpoints de listagem
- [ ] Extração do notificacao-service (microsserviço)
- [ ] CI/CD com GitHub Actions
- [ ] Deploy na AWS (EC2 + RDS + ECR)

---

## 👩‍💻 Autora

Desenvolvido por **Fernanda Lima**

[![LinkedIn](https://img.shields.io/badge/LinkedIn-Fernanda%20Lima-blue?style=flat&logo=linkedin)](https://linkedin.com/in/efernandalima)
[![GitHub](https://img.shields.io/badge/GitHub-efernandalima-black?style=flat&logo=github)](https://github.com/efernandalima)