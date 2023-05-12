package br.ucsal.avimatheuspedro.model;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Builder;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

@Data
@Entity
public class Aluno {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@JsonProperty(access = JsonProperty.Access.READ_ONLY)
	private long id;
	@Column(name="nome", nullable=false)
	private String nome;
	@Column(name="ativo", nullable=false)
	private boolean ativo;
	@Column(name="data_cadastro")
	@JsonProperty(access = JsonProperty.Access.READ_ONLY)
	@CreationTimestamp
	private LocalDateTime dataCadastro;
}
