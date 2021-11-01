package br.com.sicred.votesservice.v1.session.model.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SessionResponse {

    private String sessionId;
    private LocalDateTime openingTime;
    private LocalDateTime closingTime;
    private String scriptId;
}
