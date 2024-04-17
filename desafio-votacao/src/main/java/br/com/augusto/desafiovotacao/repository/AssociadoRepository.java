package br.com.augusto.desafiovotacao.repository;

import br.com.augusto.desafiovotacao.model.Associado;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface AssociadoRepository extends MongoRepository<Associado, String> {

    Optional<Associado> findByCpf(@Param( "cpf" ) String cpf);
}
