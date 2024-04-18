package br.com.augusto.desafiovotacao.service.impl;

import br.com.augusto.desafiovotacao.model.Associado;
import br.com.augusto.desafiovotacao.repository.AssociadoRepository;
import br.com.augusto.desafiovotacao.service.AssociadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AssociadoServiceImpl implements AssociadoService {

    @Autowired
    private AssociadoRepository repository;

    @Override
    public Associado save(Associado associado) {

        Optional<Associado> associado1 = repository.findByCpf( associado.getCpf() );
        if (associado1.isPresent())
            throw new RuntimeException("Associado já existe");
        return repository.save( associado );
    }

    @Override
    public Page<Associado> findAll(Pageable pageable) {
        return repository.findAll( pageable );
    }

    @Override
    public ResponseEntity delete(String id) {

        repository.deleteById( id );
        return ResponseEntity.noContent().build();
    }

    @Override
    public Optional<Associado> findById(String id) {
        return repository.findById( id );
    }
}
