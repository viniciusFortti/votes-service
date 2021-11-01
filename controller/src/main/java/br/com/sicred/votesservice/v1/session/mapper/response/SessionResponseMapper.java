package br.com.sicred.votesservice.v1.session.mapper.response;

import br.com.sicred.votesservice.v1.session.model.response.SessionResponse;
import br.com.sicred.votesservice.v1.session.model.response.SessionResponseModel;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class SessionResponseMapper {

    public static SessionResponse sessionModelToResponse(SessionResponseModel sessionResponse) {
        return SessionResponse.builder()
                .sessionId(sessionResponse.getId())
                .closingTime(sessionResponse.getClosingTime())
                .openingTime(sessionResponse.getOpeningTime())
                .scriptId(sessionResponse.getScriptId())
                .build();
    }

}
