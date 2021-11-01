package br.com.sicred.votesservice.v1.session.service.stub;

import br.com.sicred.votesservice.v1.session.model.response.SessionResponseModel;

import java.time.LocalDateTime;

public class SessionResponseStub {


    public static SessionResponseModel sessionOpenResponseStub() {
        return SessionResponseModel.builder()
                .alreadyCalculated(false)
                .scriptId("teste")
                .id("teste")
                .openingTime(LocalDateTime.now().minusHours(5))
                .closingTime(LocalDateTime.now().plusHours(10))
                .build();
    }


    public static SessionResponseModel sessionCloneResponseStub() {
        return SessionResponseModel.builder()
                .alreadyCalculated(false)
                .scriptId("teste")
                .id("teste")
                .openingTime(LocalDateTime.now().minusHours(5))
                .closingTime(LocalDateTime.now().minusHours(2))
                .build();
    }
}
