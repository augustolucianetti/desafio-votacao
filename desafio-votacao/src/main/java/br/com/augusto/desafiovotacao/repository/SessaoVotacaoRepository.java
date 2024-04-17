package br.com.augusto.desafiovotacao.repository;

import br.com.augusto.desafiovotacao.model.SessaoVotacao;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.query.Param;

public interface SessaoVotacaoRepository extends MongoRepository<SessaoVotacao, String> {

}
