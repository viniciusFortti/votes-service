package br.com.sicred.votesservice.v1.associate;


import br.com.sicred.votesservice.associate.facade.AssociateRestFacade;
import br.com.sicred.votesservice.associate.model.response.ValidationRestResponse;
import br.com.sicred.votesservice.v1.vote.model.request.VoteRequestModel;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.server.ResponseStatusException;

@AllArgsConstructor
@Service
@Slf4j
public class AssociateService {

    private final AssociateRestFacade associateRestFacade;

    public boolean validateCpfAssociate(VoteRequestModel voteRequest) {
        try {
            log.info("[POST VOTE VALIDATE CPF] - INICIANDO VALIDAÇÃO DE CPF DO ASSOCIADO");
            return verifyAbleToVote(associateRestFacade.validateCpf(voteRequest.getAssociateCpf()));
        } catch (HttpClientErrorException clientErrorException) {
            throw logAndThrowCpfInvalid(clientErrorException);
        }
    }

    private boolean verifyAbleToVote(ValidationRestResponse validateCpf) {
        if (validateCpf.getStatus().equalsIgnoreCase("ABLE_TO_VOTE")) return true;
        else {
            log.info("[POST VOTE VALIDATE CPF] - ERRO: ASSOCIADO NAO ELEGÍVEL A VOTO");
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Associado não é elegível a voto");
        }
    }

    private ResponseStatusException logAndThrowCpfInvalid(HttpClientErrorException exception) {
        if (exception.getStatusCode().equals(HttpStatus.NOT_FOUND)) {
            log.info("[POST VOTE VALIDATE CPF] - ERRO: CPF INVALIDO");
            return new ResponseStatusException(HttpStatus.BAD_REQUEST, "Cpf invalido");
        } else {
            log.info("[POST VOTE VALIDATE CPF] - ERRO: FALHA AO VALIDAR CPF, MESSAGE: {}", exception.getMessage());
            return new ResponseStatusException(exception.getStatusCode(),
                    "Falha ao validar cpf, ERRO: " + exception.getMessage());
        }
    }

}
