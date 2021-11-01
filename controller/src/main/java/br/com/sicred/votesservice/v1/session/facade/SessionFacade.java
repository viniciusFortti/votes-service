package br.com.sicred.votesservice.v1.session.facade;

import br.com.sicred.votesservice.v1.session.model.request.SessionRequest;
import br.com.sicred.votesservice.v1.session.model.response.SessionResponse;
import br.com.sicred.votesservice.v1.session.service.SessionService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import static br.com.sicred.votesservice.v1.session.mapper.request.SessionRequestMapper.sessionRequestToModel;
import static br.com.sicred.votesservice.v1.session.mapper.response.SessionResponseMapper.sessionModelToResponse;

@Component
@AllArgsConstructor
public class SessionFacade {

    private final SessionService sessionService;

    public SessionResponse createSession(SessionRequest sessionRequest) {
        return sessionModelToResponse(sessionService.createSession(sessionRequestToModel(sessionRequest)));
    }

    public SessionResponse findSession(String idSession) {
        return sessionModelToResponse(sessionService.findSession(idSession));
    }

    public void deleteSession(String idSession) {
        sessionService.deleteSession(idSession);
    }

}
