package br.com.sicred.votesservice.v1.message;

import br.com.sicred.votesservice.v1.vote.model.response.ResultVoteResponseModel;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Slf4j
@AllArgsConstructor
@Component
public class KafkaProducer {

    private final KafkaTemplate<String, String> kafkaTemplate;

    public void sendMessage(String topic, ResultVoteResponseModel resultVote) {
        try {
            kafkaTemplate.send(topic, new ObjectMapper().writeValueAsString(resultVote));
        } catch (JsonProcessingException jsonProcessingException) {
            log.error("[JOB RESULT] - ERRO AO ENVIAR MENSAGEM, ERRO: {}", jsonProcessingException.getMessage());
        }
    }
}