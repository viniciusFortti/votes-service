package br.com.sicred.votesservice.v1.script.model.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Document("script")
public class ScriptEntity {

    @Id
    private String id;
    private String description;
    private LocalDateTime openingTime;
    private LocalDateTime closingTime;
    private String title;
}
