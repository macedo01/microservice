package br.ucsal.avimatheuspedro.model;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Builder;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

@Data
@Entity
public class AtividadeAprovada {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@JsonProperty(access = JsonProperty.Access.READ_ONLY)
	private long id;
	@ManyToOne
	private Aluno aluno;
	@ManyToOne
	private AtividadeComplementar atividadeComplementar;
	@Column(name="ativo", nullable=false)
	private boolean ativo;
	@Column(name="data_cadastro")
	@CreationTimestamp
	@JsonProperty(access = JsonProperty.Access.READ_ONLY)
	private LocalDateTime dataCadastro;
}
