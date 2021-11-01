package br.com.sicred.votesservice.v1.script.model.response;


import io.swagger.annotations.ApiModel;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@ApiModel
public class ScriptResponse {

    private String idScript;
    private String description;
    private String title;
}
