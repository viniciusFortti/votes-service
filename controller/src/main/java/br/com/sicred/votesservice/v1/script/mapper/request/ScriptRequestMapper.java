package br.com.sicred.votesservice.v1.script.mapper.request;

import br.com.sicred.votesservice.v1.script.model.request.ScriptRequest;
import br.com.sicred.votesservice.v1.script.model.request.ScriptRequestModel;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ScriptRequestMapper {

    public static ScriptRequestModel scriptRequestToModel(ScriptRequest scriptRequest) {
        return ScriptRequestModel.builder()
                .id(scriptRequest.getId())
                .description(scriptRequest.getDescription())
                .title(scriptRequest.getTitle())
                .build();
    }
}
