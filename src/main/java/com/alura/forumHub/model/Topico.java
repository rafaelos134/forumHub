package com.alura.forumHub.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;

import java.time.LocalDateTime;


@Entity
public class Topico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty(message = "Título é obrigatório")
    private String titulo;

    @NotEmpty(message = "Mensagem é obrigatória")
    private String mensagem;

    @NotEmpty(message = "Autor é obrigatório")
    private String autor;

    @NotEmpty(message = "Curso é obrigatório")
    private String curso;

    private int ano;

    private LocalDateTime dataCriacao;

    @PrePersist
    protected void onCreate() {
        // Atribuindo a data de criação com o ano enviado
        dataCriacao = LocalDateTime.of(ano, 1, 1, 0, 0, 0, 0);
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getTitulo() { return titulo; }
    public void setTitulo(String titulo) { this.titulo = titulo; }

    public String getMensagem() { return mensagem; }
    public void setMensagem(String mensagem) { this.mensagem = mensagem; }

    public String getAutor() { return autor; }
    public void setAutor(String autor) { this.autor = autor; }

    public String getCurso() { return curso; }
    public void setCurso(String curso) { this.curso = curso; }

    public int getAno() {
        return ano;}
    public void setAno(int ano) {
        this.ano = ano; }
}
