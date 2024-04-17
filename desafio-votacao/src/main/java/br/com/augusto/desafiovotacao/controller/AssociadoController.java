package br.com.augusto.desafiovotacao.controller;

import br.com.augusto.desafiovotacao.model.Associado;
import br.com.augusto.desafiovotacao.service.AssociadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/associado")
public class AssociadoController {

    @Autowired
    private AssociadoService service;

    @GetMapping
    public Page<Associado> getAll(@RequestParam(value = "page", defaultValue = "0") int page,
                                  @RequestParam(value = "size", defaultValue = "10") int size) {
        Pageable pageable = PageRequest.of(page, size);
        return service.findAll( pageable );
    }

    @PostMapping
    Associado creteAsociado(@RequestBody Associado associado) {

        return service.save( associado );
    }

    ResponseEntity delete(@RequestParam  String id) {
        return service.delete( id );
    }
}
