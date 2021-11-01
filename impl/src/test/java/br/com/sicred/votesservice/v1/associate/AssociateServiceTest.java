package br.com.sicred.votesservice.v1.associate;

import br.com.sicred.votesservice.associate.facade.AssociateRestFacade;
import br.com.sicred.votesservice.v1.associate.stub.ValidationRestResponseStub;
import br.com.sicred.votesservice.v1.associate.stub.VoteRequestModelStub;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class AssociateServiceTest {


    @Mock
    private AssociateRestFacade associateRestFacade;

    @InjectMocks
    private AssociateService associateService;

    @Test
    void validateCpfAssociateThenReturnTrue() {
        when(associateRestFacade.validateCpf(any())).thenReturn(ValidationRestResponseStub.stubVoteAble());

        Assertions.assertTrue(associateService.validateCpfAssociate(VoteRequestModelStub.voteRequestStub()));
    }

    @Test
    void validateCpfAssociateThenReturnFalse() {
        when(associateRestFacade.validateCpf(any())).thenReturn(ValidationRestResponseStub.stubVoteNotAble());

        assertThrows(ResponseStatusException.class, () ->
                associateService.validateCpfAssociate(VoteRequestModelStub.voteRequestStub()));
    }


    @Test
    void validateCpfAssociateThenReturnFalseWithCPFInvalid() {
        when(associateRestFacade.validateCpf(any())).thenThrow(new ResponseStatusException(HttpStatus.NOT_FOUND, ""));

        assertThrows(ResponseStatusException.class, () ->
                associateService.validateCpfAssociate(VoteRequestModelStub.voteRequestStub()));
    }
}