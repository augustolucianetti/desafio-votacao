package br.com.augusto.desafiovotacao.service.impl;

import br.com.augusto.desafiovotacao.model.Pauta;
import br.com.augusto.desafiovotacao.repository.PautaRepository;
import br.com.augusto.desafiovotacao.service.PautaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class PautaServiceImpl implements PautaService {

    @Autowired
    PautaRepository pautaRepository;

    @Override
    public Pauta save(Pauta voting) {

        return pautaRepository.save( voting );
    }

    @Override
    public Page<Pauta> findAll(Pageable pageable) {
        return pautaRepository.findAll( pageable );
    }

    @Override
    public ResponseEntity delete(String id) {

        pautaRepository.deleteById( id );
        return ResponseEntity.noContent().build();
    }
}
