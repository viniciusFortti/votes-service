package br.com.sicred.votesservice.v1.script;

import br.com.sicred.votesservice.v1.script.facade.ScriptFacade;
import br.com.sicred.votesservice.v1.script.model.request.ScriptRequest;
import br.com.sicred.votesservice.v1.script.model.response.ScriptResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Api(tags = "Script")
@AllArgsConstructor
@RestController
@RequestMapping("/v1/script")
public class ScriptController {

    private final ScriptFacade scriptFacade;

    @PutMapping("/create")
    @ApiOperation(value = "criar nova pauta")
    @ResponseStatus(HttpStatus.CREATED)
    public ScriptResponse createScript(@RequestBody @Valid ScriptRequest scriptRequest) {
        return scriptFacade.createScript(scriptRequest);
    }

    @GetMapping("/{idScript}")
    @ApiOperation(value = "buscar uma pauta por id")
    @ResponseStatus(HttpStatus.OK)
    public ScriptResponse findScript(@PathVariable("idScript") String idScript) {
        return scriptFacade.findScript(idScript);
    }

}
