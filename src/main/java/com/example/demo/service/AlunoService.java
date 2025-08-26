package com.example.demo.service;

import com.example.demo.dto.AlunoDTO;
import com.example.demo.entity.Aluno;
import com.example.demo.repository.AlunoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AlunoService {

    @Autowired
    private AlunoRepository alunoRepository;

    private List<Aluno> findAllAlunos(){
        return alunoRepository.findAll();
    }

    private Optional<Aluno> findAlunoById(Long id){
        return alunoRepository.findById(id);
    }

    private Aluno saveAluno(Aluno aluno){
        return alunoRepository.save(aluno);
    }

    private void deleteAluno(Long id){
        alunoRepository.deleteById(id);
    }

    private Aluno updateAluno(Long id, Aluno updateAluno){
        return alunoRepository.findById(id)
                .map(aluno -> {
                    aluno.setNome(updateAluno.getNome());
                    aluno.setEmail(updateAluno.getEmail());
                    aluno.setDataNasc(updateAluno.getDataNasc());
                    aluno.setSenha(updateAluno.getSenha());
                    return alunoRepository.save(aluno);
                }).orElseThrow(() -> new RuntimeException("Aluno não existe!"));
    }

}