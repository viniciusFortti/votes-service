package br.com.sicred.votesservice.v1.script.model.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ScriptRequestModel {

    private String id;
    private String description;
    private String title;
}
