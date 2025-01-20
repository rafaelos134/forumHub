package com.alura.forumHub.repository;

import com.alura.forumHub.model.Topico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface TopicoRepository extends JpaRepository<Topico, Long> {
    Optional<Topico> findByTituloAndMensagem(String titulo, String mensagem);

    @Query("SELECT t FROM Topico t WHERE t.curso = :curso AND t.ano = :ano")
    List<Topico> findByCursoAndAno(@Param("curso") String curso, @Param("ano") int ano);

    Optional<Topico> findById(Long id);
    void deleteById(Long id);
} //uepas sadasda
