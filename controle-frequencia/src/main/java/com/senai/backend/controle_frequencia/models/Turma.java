package com.senai.backend.controle_frequencia.models;

import java.util.List;
import jakarta.persistence.*;

@Entity 
public class Turma {

    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; 

    private String nome;

    @OneToMany(mappedBy = "turma") 
    private List<Turma> alunos; 
    
    public Turma() {
    }

    public Turma(Long id, String nome, List<Turma> turma) {
        this.id = id;
        this.nome = nome;    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public List<Turma> getAlunos() { return alunos; }
    public void setAlunos(List<Turma> alunos) { this.alunos = alunos; }
}