package com.senai.backend.controle_frequencia.models;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;


@Entity 
public class Turma {

    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id; 

    private String nome;

    @OneToMany
    @JoinColumn(name = "id_turma")
    @Column(name = "alunos")
    private List<Turma> aluno; 
    
    public Turma() {
    }

    public Turma(Integer id, String nome, List<Turma> turma) {
        this.id = id;
        this.nome = nome;    }

    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public List<Turma> getAlunos() { return aluno; }
    public void setAlunos(List<Turma> aluno) { this.aluno = aluno; }
}