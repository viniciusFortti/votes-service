package br.com.sicred.votesservice.v1.vote.facade;

import br.com.sicred.votesservice.v1.script.model.response.ResultVotesResponse;
import br.com.sicred.votesservice.v1.vote.VoteService;
import br.com.sicred.votesservice.v1.vote.model.request.VoteRequest;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import static br.com.sicred.votesservice.v1.vote.mapper.VoteRequestMapper.resultsVotesModelToResponse;
import static br.com.sicred.votesservice.v1.vote.mapper.VoteRequestMapper.voteRequestToModel;


@Component
@AllArgsConstructor
public class VoteFacade {

    private final VoteService voteService;

    public void createVote(VoteRequest voteRequest) {
        voteService.createVote(voteRequestToModel(voteRequest));
    }


    public ResultVotesResponse resultVotes(String idSession) {
        return resultsVotesModelToResponse(voteService.calculatedResultVotes(idSession));
    }
}
