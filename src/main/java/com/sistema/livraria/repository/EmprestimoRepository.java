package com.sistema.livraria.repository;

import com.sistema.livraria.domain.entity.Emprestimo;
import com.sistema.livraria.domain.enums.StatusEmprestimo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.time.LocalDate;
import java.util.List;

@Repository
public interface EmprestimoRepository extends JpaRepository<Emprestimo, Long> {

    List<Emprestimo> findByUsuarioId(Long usuarioId);
    List<Emprestimo> findByStatus(StatusEmprestimo status);
    boolean existsByLivroIdAndStatus(Long livroId, StatusEmprestimo status);

    // Busca empréstimos atrasados (data de devolução passou e ainda estão ATIVO)
    @Query("SELECT e FROM Emprestimo e WHERE e.dataDevolucao < :hoje AND e.status = 'ATIVO'")
    List<Emprestimo> findEmprestimosAtrasados(LocalDate hoje);
}