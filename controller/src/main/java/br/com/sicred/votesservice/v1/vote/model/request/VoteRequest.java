package br.com.sicred.votesservice.v1.vote.model.request;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class VoteRequest {


    @ApiModelProperty(value = "id da sessão de votação", required = true)
    @NotNull(message = "id da sessão de votação é obrigatório")
    private String idSession;

    @ApiModelProperty(value = "cpf do associado votante", required = true)
    @NotNull(message = "cpf do associado é obrigatório")
    private String associateCpf;

    @ApiModelProperty(value = "voto do associado", required = true)
    @NotNull(message = "voto é Obrigatório")
    @Pattern(regexp = "SIM|NAO", flags = Pattern.Flag.CASE_INSENSITIVE)
    private String vote;
}
