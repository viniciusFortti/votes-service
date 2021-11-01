package br.com.sicred.votesservice.v1.session.helper;

import br.com.sicred.votesservice.v1.session.model.response.SessionResponseModel;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class SessionHelper {

    public static boolean isOpen(SessionResponseModel session) {
        return session.getOpeningTime().isBefore(session.getClosingTime()) &&
                session.getClosingTime().isAfter(LocalDateTime.now());
    }
}
