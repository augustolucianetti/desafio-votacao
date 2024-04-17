package br.com.augusto.desafiovotacao.controller;

import br.com.augusto.desafiovotacao.dto.ResultadoVotacaoDTO;
import br.com.augusto.desafiovotacao.dto.VotoDTO;
import br.com.augusto.desafiovotacao.model.Voto;
import br.com.augusto.desafiovotacao.service.VotoService;
import jakarta.websocket.server.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/voto")
public class VotoController {

    @Autowired
    private VotoService service;

    @PostMapping
    public Voto votar(@RequestBody VotoDTO votoDTO) {
        return service.save( votoDTO );
    }

    @GetMapping
    public Page<Voto> findAllBySessionId(@RequestParam(value = "page", defaultValue = "0") int page,
                                        @RequestParam(value = "size", defaultValue = "10") int size,
                                         @RequestParam String id) {

        Pageable pageable = PageRequest.of(page, size);
        return service.findAllBySessaoVotacaoId( id, pageable);
    }

    @GetMapping(value = "/resultado/pauta/{idPauta}/sessaoVotacao/{idSessao}")
    public ResponseEntity<ResultadoVotacaoDTO> getResultadoPauta(@PathVariable( "idPauta" ) String idPauta,
                                                 @PathVariable( "idSessao") String idSessao) throws Exception {
        return ResponseEntity.ok(service.getResultadoVotacao( idSessao, idPauta ));
    }
}
