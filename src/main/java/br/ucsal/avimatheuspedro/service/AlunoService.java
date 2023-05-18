package br.ucsal.avimatheuspedro.service;

import java.util.List;
import java.util.Optional;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.ucsal.avimatheuspedro.model.Aluno;
import br.ucsal.avimatheuspedro.repository.AlunoRepository;


@Service
public class AlunoService {

	@Autowired
	private AlunoRepository repository;

	@Transactional
	public List<Aluno> addListaAluno(List<Aluno> alunos) {return repository.saveAll(alunos);}

	@Transactional
	public void deleteAluno(long id) {
		  repository.deleteById(id);
	}

	public Optional<Aluno> find(long id) {
		return repository.findById(id);
	}
}
