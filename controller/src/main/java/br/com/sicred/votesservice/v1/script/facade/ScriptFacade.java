package br.com.sicred.votesservice.v1.script.facade;

import br.com.sicred.votesservice.v1.script.model.request.ScriptRequest;
import br.com.sicred.votesservice.v1.script.model.response.ScriptResponse;
import br.com.sicred.votesservice.v1.script.service.ScriptService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import static br.com.sicred.votesservice.v1.script.mapper.request.ScriptRequestMapper.scriptRequestToModel;
import static br.com.sicred.votesservice.v1.script.mapper.response.ScriptResponseMapper.scriptModelToResponse;

@Component
@AllArgsConstructor
public class ScriptFacade {

    private final ScriptService scriptService;

    public ScriptResponse createScript(ScriptRequest scriptRequest) {
        return scriptModelToResponse(scriptService.createScript(scriptRequestToModel(scriptRequest)));
    }

    public ScriptResponse findScript(String idScript) {
        return scriptModelToResponse(scriptService.getScript(idScript));
    }
}
