package br.com.sicred.votesservice.v1.script.database;

import br.com.sicred.votesservice.v1.script.model.entity.ScriptEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ScriptRepository extends MongoRepository<ScriptEntity, String> {
}
