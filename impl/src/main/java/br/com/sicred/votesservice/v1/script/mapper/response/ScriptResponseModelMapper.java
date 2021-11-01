package br.com.sicred.votesservice.v1.script.mapper.response;

import br.com.sicred.votesservice.v1.script.model.entity.ScriptEntity;
import br.com.sicred.votesservice.v1.script.model.response.ScriptModel;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ScriptResponseModelMapper {

    public static ScriptModel entityToResponseModel(ScriptEntity scriptEntity) {
        return ScriptModel.builder()
                .scriptId(scriptEntity.getId())
                .description(scriptEntity.getDescription())
                .title(scriptEntity.getTitle())
                .build();
    }
}
