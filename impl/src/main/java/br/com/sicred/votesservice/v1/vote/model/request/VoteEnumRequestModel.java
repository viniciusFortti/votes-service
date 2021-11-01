package br.com.sicred.votesservice.v1.vote.model.request;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import java.util.Arrays;

public enum VoteEnumRequestModel {

    FAVOR("SIM"),
    AGAINST("NAO");

    private final String vote;


    VoteEnumRequestModel(String vote) {
        this.vote = vote;
    }

    public String getVote() {
        return this.vote;
    }

    public static VoteEnumRequestModel getByValue(String voteRequest) {
        return Arrays.stream(VoteEnumRequestModel.values())
                .filter(voteEnum -> voteEnum.getVote().equals(voteRequest))
                .findFirst()
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.BAD_REQUEST, "Voto fora do padrão correto, valores aceitos : SIM/NAO"));
    }
}
