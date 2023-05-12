package br.ucsal.avimatheuspedro.model;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Builder;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

@Data
@Entity
public class AtividadeComplementar {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@JsonProperty(access = JsonProperty.Access.READ_ONLY)
	private long id;
	@Column(name="descricao", nullable=false)
	private String descricao;
	@Column(name="carga_horaria_maxima", nullable=false)
	private Integer cargaHorariaMaxima;
	@Column(name="ativo", nullable=false)
	private boolean ativo;
	@Column(name="data_cadastro")
	@CreationTimestamp
	@JsonProperty(access = JsonProperty.Access.READ_ONLY)
	private LocalDateTime dataCadastro;
}
