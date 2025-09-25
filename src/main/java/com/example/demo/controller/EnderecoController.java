package com.example.demo.controller;

import com.example.demo.entity.Endereco;
import com.example.demo.service.EnderecoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("endereco")
public class EnderecoController {

    @Autowired
    private EnderecoService enderecoService;

    @GetMapping
    public List<Endereco> listarEnderecos(){
        return enderecoService.findAllEndereco();
    }

    @PostMapping("/{id}")
    public Endereco salvarEndereco(@PathVariable Long id, @RequestBody Endereco endereco){
        return enderecoService.saveEndereco(id, endereco);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Endereco> updateEndereco(@PathVariable Long id, @RequestBody Endereco novoEndereco){
        Endereco endereco = enderecoService.updateEnderecoByAlunoId(id, novoEndereco);
        return ResponseEntity.ok(endereco);
    }

    @DeleteMapping("/{id}")
    private ResponseEntity<Void> excluirEndereco(@PathVariable Long id){
        enderecoService.deleteEndereco(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}