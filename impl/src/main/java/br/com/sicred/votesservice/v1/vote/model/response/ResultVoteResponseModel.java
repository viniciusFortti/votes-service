package br.com.sicred.votesservice.v1.vote.model.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class ResultVoteResponseModel {

    private String idSession;
    private String isScript;
    private Long votesInFavor;
    private Long votesAgainst;

}
