package br.com.sicred.votesservice.associate.facade;

import br.com.sicred.votesservice.associate.AssociateRestClient;
import br.com.sicred.votesservice.associate.model.response.ValidationRestResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@AllArgsConstructor
@Component
public class AssociateRestFacade {

    private final AssociateRestClient associateRestClient;

    public ValidationRestResponse validateCpf(String cpf) {
        return associateRestClient.validateCpfAssociate(cpf);
    }
}
