package com.example.demo.controller;

import com.example.demo.entity.Endereco;
import com.example.demo.service.EnderecoService;
import org.springframework.beans.factory.annotation.Autowired;
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

    @PostMapping
    public Endereco salvarEndereco(@RequestBody Endereco endereco){
        return enderecoService.saveEndereco(endereco);
    }

}
