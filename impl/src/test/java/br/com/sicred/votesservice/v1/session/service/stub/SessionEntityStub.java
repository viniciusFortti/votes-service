package br.com.sicred.votesservice.v1.session.service.stub;

import br.com.sicred.votesservice.v1.session.model.entity.SessionEntity;

import java.time.LocalDateTime;

public class SessionEntityStub {

    public static SessionEntity sessionOpenEntityStub() {
        return SessionEntity.builder()
                .alreadyCalculated(false)
                .id("teste")
                .closingTime(LocalDateTime.now().plusHours(5))
                .openingTime(LocalDateTime.now())
                .build();
    }

    public static SessionEntity sessionCloseEntityStub() {
        return SessionEntity.builder()
                .alreadyCalculated(false)
                .id("teste")
                .closingTime(LocalDateTime.now().minusHours(2))
                .openingTime(LocalDateTime.now().minusHours(5))
                .build();
    }
}
