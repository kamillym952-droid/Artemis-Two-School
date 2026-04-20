package com.senai.backend.controle_frequencia.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.senai.backend.controle_frequencia.models.Aluno;
import com.senai.backend.controle_frequencia.repositories.AlunoRepository;

@Service
public class AlunoService {
@Autowired
private AlunoRepository alunoRepository;

public Long contarAluno(){
    return alunoRepository.count();
}

public Aluno buscarAluno(Integer id){
    return alunoRepository.findById(id).get();
}
public List<Aluno> listarAlunos(){
    return alunoRepository.findAll();
}
public Boolean deletarAluno(Integer id){
    if (alunoRepository.existsById(id)){
        alunoRepository.deleteById(id);
        return true;
    }
    return false;
}
public Aluno cadastrarAluno(Aluno aluno){
    return alunoRepository.save(aluno);
}
public Aluno atualizarUsuario(Integer id, Aluno aluno){
    Aluno alunoRecuperado = buscarAluno(id);
    if (alunoRecuperado != null) {
        alunoRecuperado.setId(id);

        if (aluno.getNome()!= null) {
            alunoRecuperado.setNome(aluno.getNome());
        }
        if (aluno.getDataNascimento()!= null) {
            alunoRecuperado.setDataNascimento
            (aluno.getDataNascimento());
        }
        return alunoRepository.save(alunoRecuperado);
    }
    return null;
}
}