package br.com.sicred.votesservice.v1.job.property;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Getter
@Component
public class ResultJobPropertyLoader {

    @Value("${topic.name}")
    private String topicName;

}
