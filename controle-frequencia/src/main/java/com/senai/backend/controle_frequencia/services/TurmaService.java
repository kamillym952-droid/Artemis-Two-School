package com.senai.backend.controle_frequencia.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.senai.backend.controle_frequencia.repositories.TurmaRepository;
import com.senai.backend.controle_frequencia.models.Turma;
@Service
public class TurmaService {

    @Autowired
    private TurmaRepository turmaRepository;

    public Long contarTurma(){
        return turmaRepository.count();
    }

    public Turma buscarTurma(Integer id){
        return turmaRepository.findById(id).get();

    }
    public List<Turma> listarTurmas(){
        return turmaRepository.findAll();
    }
    public Boolean deletarTurma(Integer id){
        if (turmaRepository.existsById(id)){
            turmaRepository.deleteById(id);
            return true;
        }
        return false;
    }
    public Turma cadastrarTurma(Turma turma){
        return turmaRepository.save(turma);
    }
    public Turma atualizarTurma(Integer id, Turma turma){
        Turma turmaRecuperado = buscarTurma(id);
        if (turmaRecuperado != null) {
            turmaRecuperado.setId(id);

            if (turma.getNome()!= null) {
                turmaRecuperado.setNome(turma.getNome());
            }
            
            return turmaRepository.save(turmaRecuperado);
         }
         return null;
    }

}