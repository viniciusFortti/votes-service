package br.com.sicred.votesservice.v1.script.mapper.response;

import br.com.sicred.votesservice.v1.script.model.response.ScriptModel;
import br.com.sicred.votesservice.v1.script.model.response.ScriptResponse;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ScriptResponseMapper {

    public static ScriptResponse scriptModelToResponse(ScriptModel scriptModel) {
        return ScriptResponse.builder()
                .idScript(scriptModel.getScriptId())
                .description(scriptModel.getDescription())
                .title(scriptModel.getTitle())
                .build();
    }
}
