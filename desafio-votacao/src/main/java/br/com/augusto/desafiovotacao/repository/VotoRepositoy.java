package br.com.augusto.desafiovotacao.repository;

import br.com.augusto.desafiovotacao.model.Voto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VotoRepositoy extends MongoRepository<Voto, String> {

   Page<Voto> findAllBySessaoVotacao_Id(String id, Pageable pageable);
}
