package br.ucsal.avimatheuspedro.controller;

import java.util.List;
import java.util.Optional;

import br.ucsal.avimatheuspedro.DTO.AtividadeAprovadaDTO;
import br.ucsal.avimatheuspedro.model.Aluno;
import br.ucsal.avimatheuspedro.model.AtividadeComplementar;
import br.ucsal.avimatheuspedro.service.AlunoService;
import br.ucsal.avimatheuspedro.service.AtividadeComplementarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import br.ucsal.avimatheuspedro.model.AtividadeAprovada;
import br.ucsal.avimatheuspedro.service.AtividadeAprovadaService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/atividadeaprovada")
public class AtividadeAprovadaController {
	
	@Autowired
	private AtividadeAprovadaService service;

	@Autowired
	private AlunoService alunoService;

	@Autowired
	private AtividadeComplementarService atividadeComplementarService;
	
	@GetMapping
	public ResponseEntity<List<AtividadeAprovada>> listarAtividadesAprovadas(){
		return new ResponseEntity<>(service.getAll(),HttpStatus.OK);
	}
	
	@PostMapping("/adicionar")
	public ResponseEntity adicionar(@RequestBody AtividadeAprovadaDTO atividadeAprovada){
		Optional<Aluno> aluno = alunoService.find(atividadeAprovada.getIdAluno());
		Optional<AtividadeComplementar> atividadeComplementar = atividadeComplementarService.find(atividadeAprovada.getIdAtividadedComplementar());
		AtividadeAprovada atvAprovada = new AtividadeAprovada();
		try {
			atvAprovada.setAluno(aluno.get());
			atvAprovada.setAtivo(atividadeAprovada.isAtivo());
			atvAprovada.setAtividadeComplementar(atividadeComplementar.get());
		}catch (Exception e) {
			return new ResponseEntity(HttpStatus.BAD_REQUEST);
		}

		return new ResponseEntity<>(service.adicionar(atvAprovada),HttpStatus.OK);
	}
	
	
	@GetMapping("/buscarPorAluno/{id}")
	public ResponseEntity<Optional<AtividadeAprovada>> buscarPorAluno(@PathVariable long id) {
		Optional<AtividadeAprovada> alunoPorId= service.buscarAlunoPorId(id);
		if(!alunoPorId.isPresent()){
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(alunoPorId, HttpStatus.OK);
	}
	
	
	

}
