package br.ucsal.avimatheuspedro.DTO;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Schema(description = "AtvAprovada DTO")
@Data
public class AtividadeAprovadaDTO {
    @JsonProperty
    private long idAluno;
    @JsonProperty
    private long idAtividadedComplementar;
    @JsonProperty
    private boolean ativo;
}
