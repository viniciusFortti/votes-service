package br.com.sicred.votesservice.v1.vote.stub;

import br.com.sicred.votesservice.v1.vote.model.request.VoteEnumRequestModel;
import br.com.sicred.votesservice.v1.vote.model.request.VoteRequestModel;

public class VoteRequestModelStub {

    public static VoteRequestModel voteRequestModelStub() {
        return VoteRequestModel.builder()
                .idSession("teste")
                .associateCpf("teste")
                .vote(VoteEnumRequestModel.FAVOR)
                .build();
    }
}
