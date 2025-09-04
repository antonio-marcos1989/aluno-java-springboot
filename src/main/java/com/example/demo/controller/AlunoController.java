package com.example.demo.controller;

import com.example.demo.entity.Aluno;
import com.example.demo.service.AlunoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("aluno")
public class AlunoController {

    @Autowired
    private AlunoService alunoService;

    @GetMapping
    private List<Aluno> buscarAlunos(){
        return alunoService.findAllAlunos();
    }

    @GetMapping("/{id}")
    private ResponseEntity<Aluno> buscarAlunoPorId(@PathVariable Long id){
        return alunoService.findAlunoById(id)
                .map(aluno -> new ResponseEntity<>(aluno, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    private Aluno criarAluno(@RequestBody Aluno aluno){
        return alunoService.saveAluno(aluno);
    }

    @DeleteMapping("/{id}")
    private ResponseEntity<Void> excluirAluno(@PathVariable Long id){
        alunoService.deleteAluno(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping("/{id}")
    private Aluno atualizarAluno(@PathVariable Long id, @RequestBody Aluno aluno){
        return alunoService.updateAluno(id, aluno);
    }

}