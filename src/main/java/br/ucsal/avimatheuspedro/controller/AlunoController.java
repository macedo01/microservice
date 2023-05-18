package br.ucsal.avimatheuspedro.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import br.ucsal.avimatheuspedro.model.Aluno;
import br.ucsal.avimatheuspedro.service.AlunoService;

@RestController
@RequestMapping("/api/aluno")
public class AlunoController {
	
	@Autowired
	private AlunoService service;

	@PostMapping("/adicionarAlunos")
	public ResponseEntity addListaAluno(@RequestBody List<Aluno> alunos) {
		if(alunos.size() < 3){
			return new ResponseEntity("Os Alunos não podem ser inseridos em quantidade menor do que 3...", HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity(service.addListaAluno(alunos) + " Os Alunos Foram Adicionados Com Sucesso !", HttpStatus.OK);
	}
	
	@DeleteMapping("/removerAluno/{id}")
	public ResponseEntity deleteAluno(@PathVariable long id) {
		service.deleteAluno(id);
		return new ResponseEntity("Deletado com Sucesso!",HttpStatus.OK);
	}
}
