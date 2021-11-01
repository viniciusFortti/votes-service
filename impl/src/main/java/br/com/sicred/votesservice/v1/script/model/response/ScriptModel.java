package br.com.sicred.votesservice.v1.script.model.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ScriptModel {

    private String scriptId;
    private String description;
    private String title;
}
