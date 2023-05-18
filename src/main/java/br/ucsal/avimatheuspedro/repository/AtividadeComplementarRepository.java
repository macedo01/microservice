package br.ucsal.avimatheuspedro.repository;

import org.springframework.data.jdbc.repository.query.Modifying;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import br.ucsal.avimatheuspedro.model.AtividadeComplementar;

import java.time.LocalDateTime;

@Repository
public interface AtividadeComplementarRepository  extends JpaRepository<AtividadeComplementar, Long> {}
