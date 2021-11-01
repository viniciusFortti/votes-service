package br.com.sicred.votesservice.v1.script.mapper.request;

import br.com.sicred.votesservice.v1.script.model.entity.ScriptEntity;
import br.com.sicred.votesservice.v1.script.model.request.ScriptRequestModel;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ScriptRequestModelMapper {

    public static ScriptEntity scriptModelToEntity(ScriptRequestModel scriptModel) {
        return ScriptEntity.builder()
                .id(scriptModel.getId())
                .description(scriptModel.getDescription())
                .title(scriptModel.getTitle())
                .build();

    }
}
