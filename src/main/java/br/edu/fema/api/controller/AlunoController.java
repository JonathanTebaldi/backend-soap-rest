package br.edu.fema.api.controller;

import br.edu.fema.api.domain.aluno.Aluno;
import br.edu.fema.api.domain.aluno.CadastroAlunoDTO;
import br.edu.fema.api.domain.aluno.DetalhamentoAlunoDTO;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/aluno")
public class AlunoController {

    private List<Aluno> listaAluno;

    @GetMapping
    public ResponseEntity<List<Aluno>> listarTodos(){

        return ResponseEntity.ok().build();
    }

    @PostMapping
    public ResponseEntity cadastrar(@RequestBody @Valid CadastroAlunoDTO dados){
        var aluno = new Aluno(dados);
        aluno.adcionarAluno(aluno);

        return ResponseEntity.ok().build();
    }

    @PutMapping
    public ResponseEntity atualizar(@RequestBody @Valid CadastroAlunoDTO dados){
        var aluno = new Aluno(dados);
        aluno.atualizarAluno(dados);        ;
        return ResponseEntity.ok(new DetalhamentoAlunoDTO(aluno));
    }


}
