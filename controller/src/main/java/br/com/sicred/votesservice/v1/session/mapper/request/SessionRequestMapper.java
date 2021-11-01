package br.com.sicred.votesservice.v1.session.mapper.request;

import br.com.sicred.votesservice.v1.session.model.request.SessionRequestModel;
import br.com.sicred.votesservice.v1.session.model.request.SessionRequest;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Optional;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class SessionRequestMapper {

    public static SessionRequestModel sessionRequestToModel(SessionRequest sessionRequest) {
        return SessionRequestModel.builder()
                .scriptId(sessionRequest.getScriptId())
                .closingTime(Optional.ofNullable(sessionRequest.getClosingTime()).orElse(LocalDateTime.now().plusMinutes(1)))
                .openingTime(Optional.ofNullable(sessionRequest.getOpeningTime()).orElse(LocalDateTime.now()))
                .build();
    }
}
