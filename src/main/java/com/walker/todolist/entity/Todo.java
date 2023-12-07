package com.walker.todolist.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "todos")
public class Todo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "descricao")
    private String descricao;
    @Column(name = "nome")
    private String nome;
    @Column(name = "realizado")
    private String realizado;
    @Column(name = "prioridade")
    private String prioridade;

    public Long getId() {
        return id;
    }

    public String getDescricao() {
        return descricao;
    }

    public String getNome() {
        return nome;
    }

    public String getRealizado() {
        return realizado;
    }

    public String getPrioridade() {
        return prioridade;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setRealizado(String realizado) {
        this.realizado = realizado;
    }

    public void setPrioridade(String prioridade) {
        this.prioridade = prioridade;
    }
}
