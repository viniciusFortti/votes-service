package br.com.sicred.votesservice.v1.session;

import br.com.sicred.votesservice.v1.session.facade.SessionFacade;
import br.com.sicred.votesservice.v1.session.model.request.SessionRequest;
import br.com.sicred.votesservice.v1.session.model.response.SessionResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Api(tags = "Session")
@AllArgsConstructor
@RestController
@RequestMapping("/v1/session")
public class SessionController {

    private final SessionFacade sessionFacade;

    @PostMapping("/create")
    @ApiOperation(value = "criar nova sessão de votação")
    @ResponseStatus(HttpStatus.CREATED)
    public SessionResponse createSession(@RequestBody @Valid SessionRequest sessionRequest) {
        return sessionFacade.createSession(sessionRequest);
    }


    @GetMapping("/{idSession}")
    @ApiOperation(value = "buscar uma sessão de votação por id")
    @ResponseStatus(HttpStatus.OK)
    public SessionResponse findSession(@PathVariable("idSession") String idSession) {
        return sessionFacade.findSession(idSession);
    }

    @DeleteMapping("/{idSession}")
    @ApiOperation(value = "deletar uma sessão por id")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void deleteSession(@PathVariable("idSession") String idSession) {
        sessionFacade.deleteSession(idSession);
    }

}
