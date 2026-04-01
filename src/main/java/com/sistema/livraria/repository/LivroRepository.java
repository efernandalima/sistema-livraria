package com.sistema.livraria.repository;

import com.sistema.livraria.domain.entity.Livro;
import com.sistema.livraria.domain.enums.StatusLivro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

@Repository
public interface LivroRepository extends JpaRepository<Livro, Long> {

    Optional<Livro> findByIsbn(String isbn);
    boolean existsByIsbn(String isbn);
    List<Livro> findByStatus(StatusLivro status);
    List<Livro> findByAutorId(Long autorId);

    @Query("SELECT l FROM Livro l WHERE LOWER(l.titulo) LIKE LOWER(CONCAT('%', :titulo, '%'))")
    List<Livro> findByTituloContaining(String titulo);
}