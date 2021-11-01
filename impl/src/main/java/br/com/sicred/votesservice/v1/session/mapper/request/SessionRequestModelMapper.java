package br.com.sicred.votesservice.v1.session.mapper.request;

import br.com.sicred.votesservice.v1.session.model.entity.SessionEntity;
import br.com.sicred.votesservice.v1.session.model.request.SessionRequestModel;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class SessionRequestModelMapper {

    public static SessionEntity sessionRequestToEntity(SessionRequestModel sessionRequestModel) {
        return SessionEntity.builder()
                .openingTime(sessionRequestModel.getOpeningTime())
                .closingTime(sessionRequestModel.getClosingTime())
                .scriptId(sessionRequestModel.getScriptId())
                .alreadyCalculated(false)
                .build();
    }

}
