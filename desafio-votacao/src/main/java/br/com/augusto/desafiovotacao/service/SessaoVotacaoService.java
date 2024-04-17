package br.com.augusto.desafiovotacao.service;

import br.com.augusto.desafiovotacao.dto.SessaoVotacaoDTO;
import br.com.augusto.desafiovotacao.model.SessaoVotacao;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;

import java.util.Optional;

public interface SessaoVotacaoService {

    SessaoVotacao save(SessaoVotacaoDTO sessaoVotacaoDTO) throws Exception;

    Page<SessaoVotacao> findAll(Pageable pageable);

    ResponseEntity delete(String id);

    Optional<SessaoVotacao> findById(String id);

    SessaoVotacao update(SessaoVotacao sessaoVotacao);
}
