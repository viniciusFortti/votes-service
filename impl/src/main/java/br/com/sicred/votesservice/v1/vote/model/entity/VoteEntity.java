package br.com.sicred.votesservice.v1.vote.model.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Document("vote")
public class VoteEntity {

    @Id
    private String id;
    private String idSession;
    private String associateCpf;
    private String vote;
}
