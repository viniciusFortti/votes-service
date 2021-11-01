package br.com.sicred.votesservice.associate.property;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Getter
@Component
public class AssociateProperty {

    @Value("${validation.cpf.url}")
    private String validationCpfUrl;
}
