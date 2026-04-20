package com.senai.backend.controle_frequencia.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.senai.backend.controle_frequencia.models.Turma;
import com.senai.backend.controle_frequencia.services.TurmaService;

public class TurmaController {
    @Autowired
    private TurmaService turmaService;
    @GetMapping("/contar-turma/")
    private Long contarturma(){
        return turmaService.contarTurma();
    }
    @GetMapping("/bucar-turma/(id)")
    public Turma buscarturma(@PathVariable Integer id){
        return turmaService.buscarTurma(id);
    }
    @GetMapping("/listar-turmas/")
    private List<Turma> listaturmas(){
        return turmaService.listarTurmas();
    }
    @DeleteMapping("/deletar-turma(id)")
    private String deletarturma(@PathVariable Integer id){
        if(turmaService.deletarTurma(id)){
            return "Turma deletada com sucesso";
        }
        return "Falha ao deletar turma";
    }
    @PostMapping("/cadastrar-turma/")
    public Turma cadastrarturma(@RequestBody Turma turma){
        return turmaService.cadastrarTurma(turma);
    }
    @PutMapping("/atualizar-turma/")
    public Turma atualizar(@PathVariable Integer id, @RequestBody Turma turma){
        return turmaService.atualizarTurma(id, turma);
    }
}
