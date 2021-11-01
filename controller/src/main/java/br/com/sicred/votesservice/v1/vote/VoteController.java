package br.com.sicred.votesservice.v1.vote;

import br.com.sicred.votesservice.v1.script.model.response.ResultVotesResponse;
import br.com.sicred.votesservice.v1.vote.facade.VoteFacade;
import br.com.sicred.votesservice.v1.vote.model.request.VoteRequest;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Api(tags = "Vote")
@AllArgsConstructor
@RestController
@RequestMapping("/v1/vote")
public class VoteController {

    private final VoteFacade voteFacade;

    @PostMapping("/create")
    @ApiOperation(value = "votar em uma sessão")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void createVote(@RequestBody @Valid VoteRequest voteRequest) {
        voteFacade.createVote(voteRequest);
    }

    @GetMapping("/result/{idSession}")
    @ApiOperation(value = "resultado de uma votação por id da sessão")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public ResultVotesResponse resultVotes(@PathVariable("idSession") String idSession) {
        return voteFacade.resultVotes(idSession);
    }
}
