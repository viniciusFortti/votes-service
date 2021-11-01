package br.com.sicred.votesservice.v1.associate.stub;

import br.com.sicred.votesservice.associate.model.response.ValidationRestResponse;

public class ValidationRestResponseStub {


    public static ValidationRestResponse stubVoteNotAble() {
        return ValidationRestResponse.builder().status("UNABLE_TO_VOTE").build();
    }

    public static ValidationRestResponse stubVoteAble() {
        return ValidationRestResponse.builder().status("ABLE_TO_VOTE").build();
    }
}
