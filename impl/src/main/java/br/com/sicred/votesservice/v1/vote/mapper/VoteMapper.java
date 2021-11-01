package br.com.sicred.votesservice.v1.vote.mapper;

import br.com.sicred.votesservice.v1.session.model.response.SessionResponseModel;
import br.com.sicred.votesservice.v1.vote.helper.ResultHelper;
import br.com.sicred.votesservice.v1.vote.model.entity.VoteEntity;
import br.com.sicred.votesservice.v1.vote.model.request.VoteEnumRequestModel;
import br.com.sicred.votesservice.v1.vote.model.request.VoteRequestModel;
import br.com.sicred.votesservice.v1.vote.model.response.ResultVoteResponseModel;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class VoteMapper {

    public static VoteEntity voteModelToEntity(VoteRequestModel voteRequest) {
        return VoteEntity.builder()
                .associateCpf(voteRequest.getAssociateCpf())
                .idSession(voteRequest.getIdSession())
                .vote(voteRequest.getVote().getVote())
                .build();
    }

    public static ResultVoteResponseModel resultVotesMapper(SessionResponseModel session, List<VoteEntity> votes) {
        return ResultVoteResponseModel.builder()
                .idSession(session.getId())
                .isScript(session.getScriptId())
                .votesAgainst(ResultHelper.getSumVotes(votes, VoteEnumRequestModel.AGAINST))
                .votesInFavor(ResultHelper.getSumVotes(votes, VoteEnumRequestModel.FAVOR))
                .build();
    }

}