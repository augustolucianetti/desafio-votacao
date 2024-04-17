package br.com.augusto.desafiovotacao.service;

import br.com.augusto.desafiovotacao.dto.VotoDTO;
import br.com.augusto.desafiovotacao.model.Voto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;

public interface VotoService {

    Voto save( VotoDTO votoDTO);

    Page<Voto> getAll(Pageable pageable);

    ResponseEntity delete(String id);

    Page<Voto> findAllBySessaoVotacaoId(String id, Pageable pageable);
}
