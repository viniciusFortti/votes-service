package br.com.sicred.votesservice.v1.session.database;

import br.com.sicred.votesservice.v1.session.model.entity.SessionEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SessionRepository extends MongoRepository<SessionEntity, String> {
}
