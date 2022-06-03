package dev.esdras.thymeleafforms.services;

import java.util.List;

import dev.esdras.thymeleafforms.model.entity.Curso;

public interface ICursoService {
    
    List<Curso> buscarPorNome(String nome);
    Curso inserir(Curso curso);
    List<Curso> buscarTodos();
    Curso atualizar(Curso curso);
    void remover(Integer id);
}
