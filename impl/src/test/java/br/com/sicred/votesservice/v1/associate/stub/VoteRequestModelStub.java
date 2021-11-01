package br.com.sicred.votesservice.v1.associate.stub;

import br.com.sicred.votesservice.v1.vote.model.request.VoteEnumRequestModel;
import br.com.sicred.votesservice.v1.vote.model.request.VoteRequestModel;

public class VoteRequestModelStub {


    public static VoteRequestModel voteRequestStub() {
        return VoteRequestModel.builder().associateCpf("05596482061")
                .vote(VoteEnumRequestModel.FAVOR)
                .idSession("idTest")
                .build();
    }

}
