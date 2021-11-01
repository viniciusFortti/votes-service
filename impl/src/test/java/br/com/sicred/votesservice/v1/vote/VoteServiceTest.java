package br.com.sicred.votesservice.v1.vote;

import br.com.sicred.votesservice.v1.associate.AssociateService;
import br.com.sicred.votesservice.v1.session.service.SessionService;
import br.com.sicred.votesservice.v1.vote.database.VoteRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;

import static br.com.sicred.votesservice.v1.session.service.stub.SessionResponseStub.sessionOpenResponseStub;
import static br.com.sicred.votesservice.v1.vote.stub.VoteEntityStub.voteEntitiesMoreVotesStub;
import static br.com.sicred.votesservice.v1.vote.stub.VoteEntityStub.voteEntitiesStub;
import static br.com.sicred.votesservice.v1.vote.stub.VoteRequestModelStub.voteRequestModelStub;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class VoteServiceTest {

    @Mock
    private VoteRepository voteRepository;

    @Mock
    private AssociateService associateService;

    @Mock
    private SessionService sessionService;

    @InjectMocks
    private VoteService voteService;


    @Test
    void createVoteWithAssociateNotVotedInSessionAndIsValid() {
        when(voteRepository.findAllByAssociateCpf(any())).thenReturn(new ArrayList<>());
        when(associateService.validateCpfAssociate(any())).thenReturn(true);
        when(associateService.validateCpfAssociate(any())).thenReturn(true);
        when(sessionService.verifySessionOpen(any())).thenReturn(true);

        voteService.createVote(voteRequestModelStub());

        verify(voteRepository, times(1)).save(any());
    }

    @Test
    void createVoteWithAssociateNotVotedInSessionAndIsInvalid() {
        when(voteRepository.findAllByAssociateCpf(any())).thenReturn(new ArrayList<>());
        when(associateService.validateCpfAssociate(any())).thenReturn(true);
        when(associateService.validateCpfAssociate(any())).thenReturn(false);

        voteService.createVote(voteRequestModelStub());

        verify(voteRepository, never()).save(any());

    }

    @Test
    void createVoteWithAssociateVotedInSession() {
        when(voteRepository.findAllByAssociateCpf(any())).thenReturn(voteEntitiesStub());

        assertThrows(ResponseStatusException.class, () -> voteService.createVote(voteRequestModelStub()));
    }

    @Test
    void calculatedResultVotesSumVotes() {
        when(sessionService.findSession(any())).thenReturn(sessionOpenResponseStub());
        when(voteRepository.findAllByIdSession(any())).thenReturn(voteEntitiesMoreVotesStub());

        Assertions.assertEquals(2, voteService.calculatedResultVotes("teste").getVotesAgainst());
    }
}