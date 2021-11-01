package br.com.sicred.votesservice.v1.vote.helper;

import br.com.sicred.votesservice.v1.vote.model.request.VoteEnumRequestModel;
import br.com.sicred.votesservice.v1.vote.stub.VoteEntityStub;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class ResultHelperTest {

    @Test
    void getSumVotesMustReturnValues() {
        Assertions.assertEquals(1, ResultHelper.getSumVotes(
                VoteEntityStub.voteEntitiesMoreVotesStub(), VoteEnumRequestModel.FAVOR));

        Assertions.assertEquals(2, ResultHelper.getSumVotes(
                VoteEntityStub.voteEntitiesMoreVotesStub(), VoteEnumRequestModel.AGAINST));
    }
}