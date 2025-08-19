package com.todolist.todolistproject.models;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;


@Entity
@Table(name = "tarefas")
public class Tarefas {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    
    @NotNull(message = "Título não pode ser nulo")
    private String titulo;
    @NotNull(message = "Descrição não pode ser nula")
    private String descricao;
    @NotNull
    private Boolean concluida = false;

    public Tarefas(){

    }

    public Tarefas(String titulo, String descricao, Boolean concluida){
        this.titulo = titulo;
        this.descricao = descricao;
        this.concluida = concluida;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Boolean getConcluida() {
        return concluida;
    }

    public void setConcluida(Boolean concluida) {
        this.concluida = concluida;
    }
}
