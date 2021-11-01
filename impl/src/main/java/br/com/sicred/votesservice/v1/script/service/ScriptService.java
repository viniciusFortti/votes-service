package br.com.sicred.votesservice.v1.script.service;

import br.com.sicred.votesservice.v1.script.database.ScriptRepository;
import br.com.sicred.votesservice.v1.script.model.request.ScriptRequestModel;
import br.com.sicred.votesservice.v1.script.model.response.ScriptModel;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import static br.com.sicred.votesservice.v1.script.mapper.request.ScriptRequestModelMapper.scriptModelToEntity;
import static br.com.sicred.votesservice.v1.script.mapper.response.ScriptResponseModelMapper.entityToResponseModel;

@AllArgsConstructor
@Service
@Slf4j
public class ScriptService {

    private final ScriptRepository scriptRepository;

    public ScriptModel createScript(ScriptRequestModel scriptRequestModel) {
        try {
            log.info("[PUT CREATE SCRIPT] - INICIANDO CRIAÇÃO DE PAUTA");
            return entityToResponseModel(scriptRepository.save(scriptModelToEntity(scriptRequestModel)));
        } catch (Exception ex) {
            log.info("[PUT SCRIPT] - ERRO AO SALVAR NOVA PAUTA NO BANCO, ERROR {}", ex.getClass());
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Erro interno ao Criar Pauta, ERRO: "
                    + ex.getClass());
        }
    }

    public ScriptModel getScript(String idScript) {
        log.info("[GET SCRIPT] - INICIANDO BUSCA DE SCRIPT, ID: {}", idScript);
        return entityToResponseModel(scriptRepository.findById(idScript)
                .orElseThrow(() -> logAndThrowScriptNotFound(idScript)));
    }

    private ResponseStatusException logAndThrowScriptNotFound(String idScript) {
        log.info("[GET SCRIPT] - ERRO AO BUSCAR SCRIPT, ID: {}", idScript);
        return new ResponseStatusException(HttpStatus.BAD_REQUEST, "Pauta não localizada");
    }

    public boolean verifyScriptExists(String idScript) {
        try {
            return scriptRepository.existsById(idScript);
        } catch (Exception ex) {
            log.info("[GET SCRIPT] - ERRO AO VERIFICAR SE SCRIPT EXISTE, ID: {}", idScript);
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Erro interno ao Verificar se Pauta existe," +
                    " ERRO: " + ex.getClass());
        }
    }

}
