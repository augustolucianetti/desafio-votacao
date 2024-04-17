package br.com.augusto.desafiovotacao.service;

import br.com.augusto.desafiovotacao.model.Pauta;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;


public interface PautaService {

    Pauta save(Pauta voting);

    Page<Pauta> findAll(Pageable pageable);

    ResponseEntity delete(String id);

}
