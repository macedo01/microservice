package br.ucsal.avimatheuspedro.service;

import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.ucsal.avimatheuspedro.model.AtividadeComplementar;
import br.ucsal.avimatheuspedro.repository.AtividadeComplementarRepository;

@Service
public class AtividadeComplementarService {
	
	@Autowired
	private AtividadeComplementarRepository repository;

	public AtividadeComplementar adicionar(AtividadeComplementar atividadeComplementar) {
		AtividadeComplementar atividade = repository.save(atividadeComplementar);
		return atividade;
	}

	public Optional<AtividadeComplementar> find(long idAtividadedComplementar) {
		return repository.findById(idAtividadedComplementar);
	}

	public void atualizar(AtividadeComplementar atividadeComplementar, Long id) {
		Optional<AtividadeComplementar> atvComplementar = repository.findById(id);

		if(atvComplementar.isPresent()) {
			AtividadeComplementar ativ = atvComplementar.get();
			ativ.setDescricao(atividadeComplementar.getDescricao());
			ativ.setAtivo(atividadeComplementar.isAtivo());
			ativ.setCargaHorariaMaxima(atividadeComplementar.getCargaHorariaMaxima());

			BeanUtils.copyProperties(atvComplementar, ativ);
			repository.save(ativ);
		}
	}

}
