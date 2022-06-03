package dev.esdras.thymeleafforms.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import dev.esdras.thymeleafforms.model.entity.Curso;

@Repository
public interface CursoRepository extends JpaRepository<Curso, Integer> {    
    List<Curso> findByNomeContaining(String nome);
}
