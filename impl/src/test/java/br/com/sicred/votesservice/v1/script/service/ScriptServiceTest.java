package br.com.sicred.votesservice.v1.script.service;

import br.com.sicred.votesservice.v1.script.database.ScriptRepository;
import br.com.sicred.votesservice.v1.script.model.entity.ScriptEntity;
import br.com.sicred.votesservice.v1.script.model.request.ScriptRequestModel;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.dao.DataAccessException;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ScriptServiceTest {

    @Mock
    private ScriptRepository scriptRepository;

    @InjectMocks
    private ScriptService scriptService;

    @Test
    void createScriptSuccess() {
        when(scriptRepository.save(any())).thenReturn(ScriptEntity.builder().build());

        Assertions.assertNotNull(scriptService.createScript(requestModelStub()));
    }

    @Test
    void createScriptErrorThrowExceptionTreated() {
        when(scriptRepository.save(any())).thenThrow(new DataAccessException("not access") {
        });

        assertThrows(ResponseStatusException.class, () -> scriptService.createScript(requestModelStub()));
    }

    private ScriptRequestModel requestModelStub() {
        return ScriptRequestModel.builder().description("descrição teste").title("teste").build();
    }

    @Test
    void getScriptErrorThrowExceptionTreated() {

        when(scriptRepository.findById(any())).thenReturn(Optional.empty());

        assertThrows(ResponseStatusException.class, () -> scriptService.getScript("test"));
    }

    @Test
    void verifyScriptExists() {
        when(scriptRepository.existsById(any())).thenThrow(new DataAccessException("not access") {
        });

        assertThrows(ResponseStatusException.class, () -> scriptService.verifyScriptExists("test"));
    }

}