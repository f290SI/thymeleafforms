package dev.esdras.thymeleafforms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import dev.esdras.thymeleafforms.model.entity.Curso;
import dev.esdras.thymeleafforms.repository.CursoRepository;

@Controller
public class IndexController {

    @Autowired
    private CursoRepository cursoRepository;

    @GetMapping
    public String getIndex(Model model) {
        List<Curso> cursos = cursoRepository.findAll();
        model.addAttribute("curso", new Curso());
        model.addAttribute("cursos", cursos);
        return "index";
    }
}
