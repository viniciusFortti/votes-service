package br.com.sicred.votesservice.v1.script.model.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Data
@Builder
@ApiModel
@NoArgsConstructor
@AllArgsConstructor
public class ScriptRequest {

    @ApiModelProperty(value = "id para atualização,caso id seja passado será feito um update na pauta")
    private String id;

    @ApiModelProperty(value = "descrição da pauta a ser votada")
    private String description;

    @ApiModelProperty(value = "titulo da pauta a ser votada", required = true)
    @NotNull(message = "titulo da pauta nao pode ser nulo")
    private String title;
}
