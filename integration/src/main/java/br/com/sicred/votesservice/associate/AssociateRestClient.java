package br.com.sicred.votesservice.associate;

import br.com.sicred.votesservice.associate.model.response.ValidationRestResponse;
import br.com.sicred.votesservice.associate.property.AssociateProperty;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.server.ResponseStatusException;

@AllArgsConstructor
@Slf4j
@Component
public class AssociateRestClient {

    private final RestTemplate restTemplate;
    private final AssociateProperty property;

    public ValidationRestResponse validateCpfAssociate(String request) {
        try {
            return restTemplate.exchange(property.getValidationCpfUrl().concat(request),
                    HttpMethod.GET, new HttpEntity<>(request), ValidationRestResponse.class).getBody();
        } catch (HttpClientErrorException clientErrorException) {
            throw logAndThrowCpfInvalid(clientErrorException);
        } catch (Exception ex) {
            log.info("[POST VOTE VALIDATE CPF] - ERRO AO VALIDAR CPF");
            throw new ResponseStatusException(
                    HttpStatus.INTERNAL_SERVER_ERROR, "Erro interno ao validar cpf, tente novamente");
        }
    }

    private ResponseStatusException logAndThrowCpfInvalid(HttpClientErrorException exception) {
        if (exception.getStatusCode().equals(HttpStatus.NOT_FOUND)) {
            log.info("[POST VOTE VALIDATE CPF] - ERRO: CPF INVALIDO");
            return new ResponseStatusException(HttpStatus.NOT_FOUND, "Cpf invalido");
        } else {
            log.info("[POST VOTE VALIDATE CPF] - ERRO: FALHA AO VALIDAR CPF, MESSAGE: {}", exception.getMessage());
            return new ResponseStatusException(exception.getStatusCode(),
                    "Falha ao validar cpf, ERRO: " + exception.getMessage());
        }
    }
}
