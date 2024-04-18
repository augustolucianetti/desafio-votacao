package br.com.augusto.desafiovotacao.controller;

import br.com.augusto.desafiovotacao.model.Pauta;
import br.com.augusto.desafiovotacao.service.PautaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/pauta")
public class PautaController {

    @Autowired
    PautaService pautaService;

    @PostMapping
    public ResponseEntity createVoting(@RequestBody Pauta voting) {

        return ResponseEntity.ok().body( pautaService.save( voting ) );
    }

    @GetMapping
    public Page<Pauta> getAll(@RequestParam(value = "page", defaultValue = "0") int page,
                              @RequestParam(value = "size", defaultValue = "10") int size) {

        Pageable pageable = PageRequest.of(page, size);
        return pautaService.findAll( pageable );
    }

    @DeleteMapping
    public ResponseEntity delete(String id) {

        return pautaService.delete( id );
    }
}
