package com.senai.backend.controle_frequencia.repositories;

import com.senai.backend.controle_frequencia.models.Turma;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TurmaRepository extends JpaRepository<Turma, Integer>{

} 