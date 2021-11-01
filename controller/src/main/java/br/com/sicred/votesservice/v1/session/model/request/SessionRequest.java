package br.com.sicred.votesservice.v1.session.model.request;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SessionRequest {

    @ApiModelProperty(value = "id da pauta de votação", required = true)
    @NotNull(message = "id da pauta é obrigatório.")
    private String scriptId;

    @ApiModelProperty(value = "hora de abertura", required = true)
    @JsonFormat(pattern = "yyyy/MM/dd HH:mm")
    private LocalDateTime openingTime;

    @ApiModelProperty(value = "hora de fechamento", required = true)
    @JsonFormat(pattern = "yyyy/MM/dd HH:mm")
    private LocalDateTime closingTime;


}
