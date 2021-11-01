package br.com.sicred.votesservice.v1.script.model.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class ResultVotesResponse {

    private String idSession;
    private String idScript;
    private Long votesInFavor;
    private Long votesAgainst;
}
