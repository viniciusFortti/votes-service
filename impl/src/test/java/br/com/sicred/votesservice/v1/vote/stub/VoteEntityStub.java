package br.com.sicred.votesservice.v1.vote.stub;

import br.com.sicred.votesservice.v1.vote.model.entity.VoteEntity;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class VoteEntityStub {


    public static List<VoteEntity> voteEntitiesStub() {
        return Collections.singletonList(voteRequestFavorStub());
    }

    public static List<VoteEntity> voteEntitiesMoreVotesStub() {
        return Arrays.asList(voteRequestFavorStub(), voteRequestAgainstStub(), voteRequestAgainstStub());
    }

    private static VoteEntity voteRequestFavorStub() {
        return VoteEntity.builder()
                .vote("SIM")
                .associateCpf("teste")
                .idSession("teste")
                .id("teste")
                .build();
    }

    private static VoteEntity voteRequestAgainstStub() {
        return VoteEntity.builder()
                .vote("NAO")
                .associateCpf("teste")
                .idSession("teste")
                .id("teste")
                .build();
    }

}
