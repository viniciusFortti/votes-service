package br.com.sicred.votesservice.v1.session.mapper.response;

import br.com.sicred.votesservice.v1.session.model.entity.SessionEntity;
import br.com.sicred.votesservice.v1.session.model.response.SessionResponseModel;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class SessionResponseModelMapper {

    public static List<SessionResponseModel> sessionsToResponses(List<SessionEntity> sessionsEntities) {
        return sessionsEntities.stream().map(SessionResponseModelMapper::sessionEntityToResponse)
                .collect(Collectors.toList());
    }

    public static SessionResponseModel sessionEntityToResponse(SessionEntity sessionEntity) {
        return SessionResponseModel.builder()
                .id(sessionEntity.getId())
                .scriptId(sessionEntity.getScriptId())
                .closingTime(sessionEntity.getClosingTime())
                .openingTime(sessionEntity.getOpeningTime())
                .alreadyCalculated(sessionEntity.isAlreadyCalculated())
                .build();
    }


    public static SessionEntity sessionResponseToEntity(SessionResponseModel sessionResponse) {
        return SessionEntity.builder()
                .id(sessionResponse.getId())
                .scriptId(sessionResponse.getScriptId())
                .closingTime(sessionResponse.getClosingTime())
                .openingTime(sessionResponse.getOpeningTime())
                .alreadyCalculated(sessionResponse.getAlreadyCalculated())
                .build();
    }
}
