package br.com.sicred.votesservice.v1.session.model.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class SessionResponseModel {

    private String id;
    private String scriptId;
    private LocalDateTime openingTime;
    private LocalDateTime closingTime;
    private Boolean alreadyCalculated;

}
