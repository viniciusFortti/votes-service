package br.com.sicred.votesservice.v1.vote.model.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class VoteRequestModel {

    private String idSession;
    private String associateCpf;
    private VoteEnumRequestModel vote;
}
