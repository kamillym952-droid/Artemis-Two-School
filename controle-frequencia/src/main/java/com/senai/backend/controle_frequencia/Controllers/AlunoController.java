package com.senai.backend.controle_frequencia.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.senai.backend.controle_frequencia.models.Aluno;
import com.senai.backend.controle_frequencia.services.AlunoService;

@RestController
@RequestMapping ("/aluno")
public class AlunoController {
    @Autowired
    private AlunoService alunoService;
    @GetMapping("/contar-aluno/")
    private Long contaraluno(){
        return alunoService.contarAluno();
    }
    @GetMapping("/bucar-aluno/(id)")
    public Aluno buscaraluno(@PathVariable Integer id){
        return alunoService.buscarAluno(id);
    }
    @GetMapping("/listar-alunos/")
    private List<Aluno> listaalunos(){
        return alunoService.listarAlunos();
    }
    @DeleteMapping("/deletar-aluno(id)")
    private String deletaraluno(@PathVariable Integer id){
        if(alunoService.deletarAluno(id)){
            return "aluno deletado com sucesso";
        }
        return "Falha ao deletar aluno";
    }
    @PostMapping("/salvar-aluno")
    public Aluno cadastrarAluno(@RequestBody Aluno aluno){
    return alunoService.cadastrarAluno(aluno);
    }
    @PutMapping("/atualizar-aluno/")
    public Aluno atualizar(@PathVariable Integer id, @RequestBody Aluno aluno){
        return alunoService.cadastrarAluno(aluno);
    }

}
