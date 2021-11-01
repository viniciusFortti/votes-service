package br.com.sicred.votesservice.v1.session.helper;

import br.com.sicred.votesservice.v1.session.service.stub.SessionResponseStub;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class SessionHelperTest {


    @Test
    void helperMustReturnOpenSession() {
        Assertions.assertTrue(SessionHelper.isOpen(SessionResponseStub.sessionOpenResponseStub()));
    }

    @Test
    void helperMustReturnCloseSession() {
        Assertions.assertFalse(SessionHelper.isOpen(SessionResponseStub.sessionCloneResponseStub()));
    }

}