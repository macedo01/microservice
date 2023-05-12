package br.ucsal.avimatheuspedro.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import br.ucsal.avimatheuspedro.model.AtividadeComplementar;
import br.ucsal.avimatheuspedro.service.AtividadeComplementarService;

@RestController
@RequestMapping("/api/atividadecomplementar")
public class AtividadeComplementarController {
	
	@Autowired
	private AtividadeComplementarService service;


	@PostMapping("/adicionarAtv")
	public ResponseEntity<AtividadeComplementar> adicionar(@RequestBody AtividadeComplementar atividadeComplementar){
		service.adicionar(atividadeComplementar);
		return new ResponseEntity<>(atividadeComplementar, HttpStatus.OK);
	}
	
	@PutMapping("/atualizar/{id}")
	public ResponseEntity<AtividadeComplementar> atualizar(@RequestBody AtividadeComplementar atividadeComplementar, @PathVariable long id) {
		service.atualizar(atividadeComplementar,id);
		return new ResponseEntity<>(atividadeComplementar, HttpStatus.OK);
	}
	
	
}
