package br.com.sicred.votesservice.v1.session.service;

import br.com.sicred.votesservice.v1.script.service.ScriptService;
import br.com.sicred.votesservice.v1.session.database.SessionRepository;
import br.com.sicred.votesservice.v1.session.helper.SessionHelper;
import br.com.sicred.votesservice.v1.session.model.entity.SessionEntity;
import br.com.sicred.votesservice.v1.session.model.request.SessionRequestModel;
import br.com.sicred.votesservice.v1.session.model.response.SessionResponseModel;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

import static br.com.sicred.votesservice.v1.session.mapper.request.SessionRequestModelMapper.sessionRequestToEntity;
import static br.com.sicred.votesservice.v1.session.mapper.response.SessionResponseModelMapper.sessionEntityToResponse;
import static br.com.sicred.votesservice.v1.session.mapper.response.SessionResponseModelMapper.sessionsToResponses;

@AllArgsConstructor
@Service
@Slf4j
public class SessionService {

    private final SessionRepository sessionRepository;
    private final ScriptService scriptService;

    public SessionResponseModel createSession(SessionRequestModel session) {
        log.info("[PUT CREATE SESSION] - INICIANDO CRIAÇÃO DE SESSÃO DE VOTAÇÃO");
        if (scriptService.verifyScriptExists(session.getScriptId()))
            return sessionEntityToResponse(saveSession(session));
        else {
            log.info("[PUT SESSION] - ERRO AO CRIAR SESSAO, PAUTA NÃO LOCALIZADA, idSessao: {}", session.getScriptId());
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Erro ao Criar Sessão, pauta não localizada, id "
                    + session.getScriptId());
        }
    }

    private SessionEntity saveSession(SessionRequestModel sessionRequestModel) {
        try {
            return sessionRepository.save(sessionRequestToEntity(sessionRequestModel));
        } catch (Exception ex) {
            log.info("[PUT SESSION] - ERRO AO SALVAR NOVA SESSAO DE VOTAÇÃO, ERRO: {}", ex.getClass());
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,
                    "Erro interno ao Criar Sessão, ERRO: " + ex.getClass());
        }
    }

    public boolean verifySessionOpen(String idSession) {
        if (SessionHelper.isOpen(findSession(idSession))) return true;
        else {
            log.info("[POST VOTE VALIDATE SESSION] - ERRO: SESSAO DE VOTO ESTÁ FECHADA");
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Sessão de votação já esta fechada");
        }
    }

    public SessionResponseModel findSession(String idSession) {
        return sessionEntityToResponse(sessionRepository.findById(idSession).orElseThrow(
                () -> logAndThrowSessionNotFound(idSession)));
    }

    public List<SessionResponseModel> findAllSessions() {
        return sessionsToResponses(sessionRepository.findAll());
    }


    private ResponseStatusException logAndThrowSessionNotFound(String idSession) {
        log.info("[GET SESSAO] - ERRO AO BUSCAR SESSAO, ID: {}", idSession);
        return new ResponseStatusException(HttpStatus.NOT_FOUND, "Sessão não localizada");
    }

    public void deleteSession(String idSession) {
        try {
            sessionRepository.deleteById(idSession);
        } catch (Exception ex) {
            log.info("[GET SESSION] - ERRO AO BUSCAR SESSÃO NO BANCO DE DADOS, ERRO {}", ex.getClass());
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,
                    "Erro interno ao deletar Sessão, ERRO: " + ex.getClass());
        }
    }

    public void updateSession(SessionEntity sessionEntity) {
        sessionRepository.save(sessionEntity);
    }

}