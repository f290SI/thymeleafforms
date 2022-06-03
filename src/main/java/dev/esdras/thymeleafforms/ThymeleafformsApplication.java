package dev.esdras.thymeleafforms;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import dev.esdras.thymeleafforms.model.entity.Curso;
import dev.esdras.thymeleafforms.services.CursoService;

@SpringBootApplication
public class ThymeleafformsApplication implements CommandLineRunner{

	@Autowired
	private CursoService cursoService;

	public static void main(String[] args) {
		SpringApplication.run(ThymeleafformsApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		cursoService.inserir(new Curso("Informática para Internet"));
		cursoService.inserir(new Curso("Desenvolvimento de Sistemas"));

		cursoService.buscarTodos().forEach(System.out::println);

		List<Curso> cursos = cursoService.buscarPorNome("Internet");

		System.out.println(cursos);
		
	}

}
