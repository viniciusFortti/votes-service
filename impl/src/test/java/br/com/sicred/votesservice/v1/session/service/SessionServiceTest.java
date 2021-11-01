package br.com.sicred.votesservice.v1.session.service;

import br.com.sicred.votesservice.v1.script.service.ScriptService;
import br.com.sicred.votesservice.v1.session.database.SessionRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.dao.DataAccessException;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

import static br.com.sicred.votesservice.v1.session.service.stub.SessionEntityStub.sessionCloseEntityStub;
import static br.com.sicred.votesservice.v1.session.service.stub.SessionEntityStub.sessionOpenEntityStub;
import static br.com.sicred.votesservice.v1.session.service.stub.SessionRequestModelStub.sessionRequestStub;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class SessionServiceTest {

    @Mock
    private SessionRepository sessionRepository;

    @Mock
    private ScriptService scriptService;

    @InjectMocks
    private SessionService sessionService;

    @Test
    void createSessionErrorThrowExceptionTreated() {
        when(scriptService.verifyScriptExists(any())).thenReturn(true);
        when(sessionRepository.save(any())).thenThrow(new DataAccessException("") {
        });

        assertThrows(ResponseStatusException.class, () -> sessionService.createSession(sessionRequestStub()));
    }

    @Test
    void verifySessionExistsThenReturnTrue() {
        when(sessionRepository.findById(any())).thenReturn(Optional.ofNullable(sessionOpenEntityStub()));

        Assertions.assertTrue(sessionService.verifySessionOpen("test"));
    }

    @Test
    void verifySessionExistsThenThrowException() {
        when(sessionRepository.findById(any())).thenReturn(Optional.ofNullable(sessionCloseEntityStub()));

        assertThrows(ResponseStatusException.class, () -> sessionService.verifySessionOpen("test"));
    }

}