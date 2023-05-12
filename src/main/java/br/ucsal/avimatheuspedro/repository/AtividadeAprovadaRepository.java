package br.ucsal.avimatheuspedro.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import br.ucsal.avimatheuspedro.model.AtividadeAprovada;

@Repository
public interface AtividadeAprovadaRepository  extends JpaRepository<AtividadeAprovada, Long> {

}
