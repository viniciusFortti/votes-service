package br.com.sicred.votesservice.v1.vote.helper;

import br.com.sicred.votesservice.v1.vote.model.entity.VoteEntity;
import br.com.sicred.votesservice.v1.vote.model.request.VoteEnumRequestModel;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.function.Predicate;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ResultHelper {


    public static long getSumVotes(List<VoteEntity> votesSession, VoteEnumRequestModel voteEnum) {
        return votesSession.stream().filter(voteSumPredicate(voteEnum)).count();
    }

    private static Predicate<VoteEntity> voteSumPredicate(VoteEnumRequestModel voteEnum) {
        return votes -> votes.getVote().equals(voteEnum.getVote());
    }
}
