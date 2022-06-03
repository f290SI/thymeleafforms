package dev.esdras.thymeleafforms.model.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Sugestao {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, length = 500)
    private String conteudo;

    @ManyToOne
    @JoinColumn(name = "id_tipo")
    private TipoSugestao tipo;

    @Column(nullable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private LocalDateTime data;

    
    @ManyToOne
    @JoinColumn(name = "id_curso")
    private Curso curso;

    public Sugestao(String conteudo, TipoSugestao tipo, LocalDateTime data, Curso curso) {
        this.conteudo = conteudo;
        this.tipo = tipo;
        this.data = data;
        this.curso = curso;
    }


    public Sugestao() {
    }


    public Integer getId() {
        return id;
    }


    public void setId(Integer id) {
        this.id = id;
    }


    public String getConteudo() {
        return conteudo;
    }


    public void setConteudo(String conteudo) {
        this.conteudo = conteudo;
    }


    public TipoSugestao getTipo() {
        return tipo;
    }


    public void setTipo(TipoSugestao tipo) {
        this.tipo = tipo;
    }


    public Curso getCurso() {
        return curso;
    }


    public void setCurso(Curso curso) {
        this.curso = curso;
    }

    public LocalDateTime getData() {
        return data;
    }


    public void setData(LocalDateTime data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "Sugestao [conteudo=" + conteudo + ", curso=" + curso + ", id=" + id + ", tipo=" + tipo + "]";
    }

    
}
