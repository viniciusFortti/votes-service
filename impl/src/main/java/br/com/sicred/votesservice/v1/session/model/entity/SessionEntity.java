package br.com.sicred.votesservice.v1.session.model.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@Document("session")
public class SessionEntity {

    @Id
    private String id;
    private String scriptId;
    private LocalDateTime openingTime;
    private LocalDateTime closingTime;
    private boolean alreadyCalculated;
}
