package br.com.sicred.votesservice.v1.session.service.stub;

import br.com.sicred.votesservice.v1.session.model.request.SessionRequestModel;

import java.time.LocalDateTime;

public class SessionRequestModelStub {


    public static SessionRequestModel sessionRequestStub() {
        return SessionRequestModel.builder()
                .scriptId("")
                .openingTime(LocalDateTime.now())
                .closingTime(LocalDateTime.now().plusHours(5))
                .build();
    }

}
