package br.com.augusto.desafiovotacao.service;

import br.com.augusto.desafiovotacao.model.Associado;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;

import java.util.Optional;

public interface AssociadoService {

    Associado save(Associado associado);

    Page<Associado> findAll(Pageable pageable);

    ResponseEntity delete(String id);

    Optional<Associado> findById(String id);
}
