package br.com.sicred.votesservice.v1.vote.mapper;

import br.com.sicred.votesservice.v1.script.model.response.ResultVotesResponse;
import br.com.sicred.votesservice.v1.vote.model.request.VoteEnumRequestModel;
import br.com.sicred.votesservice.v1.vote.model.request.VoteRequest;
import br.com.sicred.votesservice.v1.vote.model.request.VoteRequestModel;
import br.com.sicred.votesservice.v1.vote.model.response.ResultVoteResponseModel;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class VoteRequestMapper {

    public static VoteRequestModel voteRequestToModel(VoteRequest voteRequest) {
        return VoteRequestModel.builder()
                .associateCpf(voteRequest.getAssociateCpf())
                .vote(VoteEnumRequestModel.getByValue(voteRequest.getVote()))
                .idSession(voteRequest.getIdSession())
                .build();
    }


    public static ResultVotesResponse resultsVotesModelToResponse(ResultVoteResponseModel resultModel) {
        return ResultVotesResponse.builder()
                .idSession(resultModel.getIdSession())
                .idScript(resultModel.getIsScript())
                .votesAgainst(resultModel.getVotesAgainst())
                .votesInFavor(resultModel.getVotesInFavor())
                .build();
    }
}
