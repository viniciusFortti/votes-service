package br.com.sicred.votesservice.v1.vote.database;


import br.com.sicred.votesservice.v1.vote.model.entity.VoteEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface VoteRepository extends MongoRepository<VoteEntity, String> {

    List<VoteEntity> findAllByAssociateCpf(String cpf);

    List<VoteEntity> findAllByIdSession(String idSession);


}
