package com.sistema.livraria.repository;

import com.sistema.livraria.domain.entity.Autor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface AutorRepository extends JpaRepository<Autor, Long> {

    Optional<Autor> findByNomeIgnoreCase(String nome);
    boolean existsByNomeIgnoreCase(String nome);
}