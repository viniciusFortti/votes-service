package br.com.sicred.votesservice.v1.vote;

import br.com.sicred.votesservice.v1.associate.AssociateService;
import br.com.sicred.votesservice.v1.session.service.SessionService;
import br.com.sicred.votesservice.v1.vote.database.VoteRepository;
import br.com.sicred.votesservice.v1.vote.mapper.VoteMapper;
import br.com.sicred.votesservice.v1.vote.model.entity.VoteEntity;
import br.com.sicred.votesservice.v1.vote.model.request.VoteRequestModel;
import br.com.sicred.votesservice.v1.vote.model.response.ResultVoteResponseModel;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

import static br.com.sicred.votesservice.v1.vote.mapper.VoteMapper.resultVotesMapper;

@AllArgsConstructor
@Service
@Slf4j
public class VoteService {

    private final VoteRepository voteRepository;
    private final AssociateService associateService;
    private final SessionService sessionService;


    public void createVote(VoteRequestModel voteRequest) {
        log.info("[PUT CREATE SCRIPT] - INICIANDO CRIAÇÃO DE VOTO, NA SESSAO : {}", voteRequest.getIdSession());
        verifyAssociatedAlreadyVote(voteRequest);
        if (ableToVote(voteRequest) && sessionOpen(voteRequest)) {
            saveVote(voteRequest);
        }
    }

    private boolean ableToVote(VoteRequestModel voteRequest) {
        return associateService.validateCpfAssociate(voteRequest);
    }

    private void verifyAssociatedAlreadyVote(VoteRequestModel voteRequestModel) {
        voteRepository.findAllByAssociateCpf(voteRequestModel.getAssociateCpf()).stream()
                .filter(vote -> vote.getIdSession().equals(voteRequestModel.getIdSession()))
                .findAny().ifPresent(vote -> {
            log.info("[POST VOTE VALIDATE CPF] - ERRO: ASSOCIADO JÁ VOTOU NA SESSAO");
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Associado já votou nesta sessão");
        });
    }

    private boolean sessionOpen(VoteRequestModel voteRequest) {
        return sessionService.verifySessionOpen(voteRequest.getIdSession());
    }

    private void saveVote(VoteRequestModel voteRequest) {
        voteRepository.save(VoteMapper.voteModelToEntity(voteRequest));
    }

    public ResultVoteResponseModel calculatedResultVotes(String idSession) {
        return resultVotesMapper(sessionService.findSession(idSession), getAllByIdSession(idSession));
    }

    public List<VoteEntity> getAllByIdSession(String idSession) {
        return voteRepository.findAllByIdSession(idSession);
    }

}

