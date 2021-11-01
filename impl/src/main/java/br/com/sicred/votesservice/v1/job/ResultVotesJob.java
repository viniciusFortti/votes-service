package br.com.sicred.votesservice.v1.job;

import br.com.sicred.votesservice.v1.job.property.ResultJobPropertyLoader;
import br.com.sicred.votesservice.v1.message.KafkaProducer;
import br.com.sicred.votesservice.v1.session.helper.SessionHelper;
import br.com.sicred.votesservice.v1.session.model.response.SessionResponseModel;
import br.com.sicred.votesservice.v1.session.service.SessionService;
import br.com.sicred.votesservice.v1.vote.VoteService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

import static br.com.sicred.votesservice.v1.session.mapper.response.SessionResponseModelMapper.sessionResponseToEntity;

@AllArgsConstructor
@Slf4j
@Component
public class ResultVotesJob {

    private final SessionService sessionService;
    private final VoteService voteService;
    private final KafkaProducer kafkaProducer;
    private final ResultJobPropertyLoader properties;


    @Scheduled(cron = "${job.result.delay}")
    public void pushMessagesResult() {
        log.info("[JOB RESULT VOTE] - INICIANDO JOB DE RESULTADO DAS VOTAÇÕES");
        filterSessionsAbleToMessage().forEach(session -> {
            kafkaProducer.sendMessage(properties.getTopicName(), voteService.calculatedResultVotes(session.getId()));
            updateSessionMessageSent(session);
        });
        log.info("[JOB RESULT VOTE] - FINALIZANDO JOB DE RESULTADO DAS VOTAÇÕES COM SUCCESSO");
    }

    private void updateSessionMessageSent(SessionResponseModel session) {
        session.setAlreadyCalculated(Boolean.TRUE);
        sessionService.updateSession(sessionResponseToEntity(session));
    }

    private List<SessionResponseModel> filterSessionsAbleToMessage() {
        return sessionService.findAllSessions().stream()
                .filter(session -> !SessionHelper.isOpen(session) && !session.getAlreadyCalculated())
                .collect(Collectors.toList());
    }
}

