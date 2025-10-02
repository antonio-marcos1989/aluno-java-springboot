package com.example.demo.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Curso {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String descricao;
    private int cargaHoraria;
    private int qtdeSemestre;

    @ManyToOne
    @JoinColumn(name = "centro_id")
    private Centro centro;

    @ManyToMany(mappedBy = "cursos")
    private List<Aluno> alunos;

    public Curso() {
    }

    public Curso(Long id, String nome, String descricao, int cargaHoraria, int qtdeSemestre, Centro centro) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
        this.cargaHoraria = cargaHoraria;
        this.qtdeSemestre = qtdeSemestre;
        this.centro = centro;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public int getCargaHoraria() {
        return cargaHoraria;
    }

    public void setCargaHoraria(int cargaHoraria) {
        this.cargaHoraria = cargaHoraria;
    }

    public int getQtdeSemestre() {
        return qtdeSemestre;
    }

    public void setQtdeSemestre(int qtdeSemestre) {
        this.qtdeSemestre = qtdeSemestre;
    }

    public Centro getCentro() {
        return centro;
    }

    public void setCentro(Centro centro) {
        this.centro = centro;
    }

    public List<Aluno> getAlunos() {
        return alunos;
    }

    public void setAlunos(List<Aluno> alunos) {
        this.alunos = alunos;
    }
}
