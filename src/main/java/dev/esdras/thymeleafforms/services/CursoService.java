package dev.esdras.thymeleafforms.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.google.common.base.Strings;

import dev.esdras.thymeleafforms.model.entity.Curso;
import dev.esdras.thymeleafforms.repository.CursoRepository;

@Service
public class CursoService implements ICursoService {

    private final CursoRepository repository;

    public CursoService(CursoRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Curso> buscarPorNome(String nome) {
        if(Strings.isNullOrEmpty(nome)) {
            throw new RuntimeException("O nome do curso não pode ser vazio.");
        }

        return repository.findByNomeContaining(nome);
    }

    @Override
    public Curso inserir(Curso curso) {
        validarNome(curso.getNome());
        return repository.save(curso);
    }

    @Override
    public List<Curso> buscarTodos() {
        return repository.findAll();
    }

    @Override
    public Curso atualizar(Curso curso) {
        validarNome(curso.getNome());
        validarExistencia(curso.getId());

        return repository.save(curso);
    }

    @Override
    public void remover(Integer id) {
        validarExistencia(id);
        Optional<Curso> optionalCurso = repository.findById(id);
        repository.delete(optionalCurso.get());
    }

    private void validarNome(String curso) {
        if (Strings.isNullOrEmpty(curso)) {
            throw new RuntimeException("O nome do curso não pode ser vazio.");
        }
    }

    private void validarExistencia(Integer id) {
        if (repository.findById(id).isEmpty()) {
            throw new RuntimeException("O curso não foi localizado.");
        }
    }

}
