package br.com.augusto.desafiovotacao.repository;

import br.com.augusto.desafiovotacao.model.Pauta;
import org.springframework.data.domain.Page;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.awt.print.Pageable;

@Repository
public interface PautaRepository extends MongoRepository<Pauta, String> {

}
