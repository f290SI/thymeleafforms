package dev.esdras.thymeleafforms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import dev.esdras.thymeleafforms.model.entity.Curso;
import dev.esdras.thymeleafforms.services.CursoService;

@RequestMapping("/cursos")
@Controller
public class CursoController {

    @Autowired
    private CursoService service;
    
    @GetMapping("/cadastro")
    public String adicionar(Curso curso) {
        return "curso/adicionar";
    }

    @PostMapping("/salvar")
    public String salvar(Curso curso) {
        service.inserir(curso);
        return "redirect:/cursos/cadastro";
    }
}
