CREATE TABLE autores (
                         id          BIGSERIAL PRIMARY KEY,
                         nome        VARCHAR(200) NOT NULL,
                         nascimento  DATE,
                         created_at  TIMESTAMP DEFAULT NOW(),
                         updated_at  TIMESTAMP DEFAULT NOW()
);

CREATE TABLE livros (
                        id          BIGSERIAL PRIMARY KEY,
                        titulo      VARCHAR(200) NOT NULL,
                        isbn        VARCHAR(20) UNIQUE NOT NULL,
                        status      VARCHAR(20) NOT NULL DEFAULT 'DISPONIVEL',
                        autor_id    BIGINT NOT NULL REFERENCES autores(id),
                        created_at  TIMESTAMP DEFAULT NOW(),
                        updated_at  TIMESTAMP DEFAULT NOW()
);

CREATE TABLE usuarios (
                          id       BIGSERIAL PRIMARY KEY,
                          nome     VARCHAR(200) NOT NULL,
                          email    VARCHAR(200) UNIQUE NOT NULL,
                          senha    VARCHAR(255) NOT NULL,
                          role     VARCHAR(20) NOT NULL DEFAULT 'USER',
                          created_at TIMESTAMP DEFAULT NOW()
);

CREATE TABLE emprestimos (
                             id              BIGSERIAL PRIMARY KEY,
                             livro_id        BIGINT NOT NULL REFERENCES livros(id),
                             usuario_id      BIGINT NOT NULL REFERENCES usuarios(id),
                             data_emprestimo DATE NOT NULL DEFAULT CURRENT_DATE,
                             data_devolucao  DATE NOT NULL,
                             status          VARCHAR(20) NOT NULL DEFAULT 'ATIVO',
                             created_at      TIMESTAMP DEFAULT NOW()
);