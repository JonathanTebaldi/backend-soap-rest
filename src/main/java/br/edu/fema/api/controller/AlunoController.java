package br.edu.fema.api.controller;

import br.edu.fema.api.domain.aluno.Aluno;
import br.edu.fema.api.domain.aluno.CadastroAlunoDTO;
import br.edu.fema.api.domain.aluno.DetalhamentoAlunoDTO;
import br.edu.fema.api.service.AlunoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/aluno")
public class AlunoController {
    @Autowired
    private AlunoService alunoService;

    @GetMapping
    public ResponseEntity<List<Aluno>> listarTodos(){
        return ResponseEntity.status(HttpStatus.OK).body(alunoService.listarAlunos());
    }

    @PostMapping
    public ResponseEntity cadastrar(@RequestBody @Valid CadastroAlunoDTO dados){
        var aluno = new Aluno(dados);
        alunoService.adcionarAluno(aluno);

        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity atualizar(@PathVariable("id") UUID id, @RequestBody @Valid CadastroAlunoDTO dados){
        var aluno = alunoService.atualizarAluno(id, dados);
        return ResponseEntity.status(HttpStatus.OK).body(new DetalhamentoAlunoDTO(aluno)) ;
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deletar(@PathVariable("id") UUID id) {
        alunoService.removerAluno(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @GetMapping("/imc/{id}")
    public ResponseEntity imc(@PathVariable ("id") UUID id){
        Double imc = alunoService.calcularImc(id);
        return ResponseEntity.status(HttpStatus.OK).body(
                alunoService.verificarImc(imc) + ": " + imc
        );
    }
}
