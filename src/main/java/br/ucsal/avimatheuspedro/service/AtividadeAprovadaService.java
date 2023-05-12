package br.ucsal.avimatheuspedro.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import br.ucsal.avimatheuspedro.model.AtividadeAprovada;
import br.ucsal.avimatheuspedro.repository.AtividadeAprovadaRepository;

@Service
public class AtividadeAprovadaService {

	@Autowired
	private AtividadeAprovadaRepository repository;

	public List<AtividadeAprovada> getAll() {
		List<AtividadeAprovada> all = repository.findAll();
		return all;
	}

	public AtividadeAprovada adicionar(AtividadeAprovada atividadeAprovada) {
		AtividadeAprovada atividade = repository.save(atividadeAprovada);
		return atividade;
	}

	public Optional<AtividadeAprovada> buscarAlunoPorId(long id) {
		Optional<AtividadeAprovada> aluno = repository.findById(id);
		return aluno;
	}

}
