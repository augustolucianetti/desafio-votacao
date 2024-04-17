package br.com.augusto.desafiovotacao.controller;

import br.com.augusto.desafiovotacao.dto.SessaoVotacaoDTO;
import br.com.augusto.desafiovotacao.model.Pauta;
import br.com.augusto.desafiovotacao.model.SessaoVotacao;
import br.com.augusto.desafiovotacao.service.SessaoVotacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/sessaoVotacao")
public class SessaoVotacaoController {

    @Autowired
    private SessaoVotacaoService service;

    @PostMapping
    public ResponseEntity createSessaoVotacao(@RequestBody SessaoVotacaoDTO sessaoVotacaoDTO) throws Exception {

        return ResponseEntity.ok().body( service.save( sessaoVotacaoDTO ) );
    }

    @GetMapping
    public Page<SessaoVotacao> getAll(@RequestParam(value = "page", defaultValue = "0") int page,
                                      @RequestParam(value = "size", defaultValue = "10") int size) {

        Pageable pageable = PageRequest.of(page, size);
        return service.findAll( pageable );
    }
}
