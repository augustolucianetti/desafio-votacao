package br.com.augusto.desafiovotacao.service.impl;

import br.com.augusto.desafiovotacao.dto.SessaoVotacaoDTO;
import br.com.augusto.desafiovotacao.model.Pauta;
import br.com.augusto.desafiovotacao.model.SessaoVotacao;
import br.com.augusto.desafiovotacao.repository.PautaRepository;
import br.com.augusto.desafiovotacao.repository.SessaoVotacaoRepository;
import br.com.augusto.desafiovotacao.service.SessaoVotacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class SessaoVotacaoServiceImpl implements SessaoVotacaoService {

    @Autowired
    private SessaoVotacaoRepository repository;

    @Autowired
    PautaRepository pautaRepository;


    @Override
    public SessaoVotacao save(SessaoVotacaoDTO sessaoVotacaoDTO) throws Exception {

        SessaoVotacao sessaoVotacao = new SessaoVotacao();
        sessaoVotacao.setEndDate( sessaoVotacaoDTO.getEndDate() );
        sessaoVotacao.setStartDate( sessaoVotacaoDTO.getStartDate() );
        Optional<Pauta> pauta = pautaRepository.findById( sessaoVotacaoDTO.getIdPauta() );
        if (pauta.isPresent())
            sessaoVotacao.setPauta( pauta.get() );
        else
            throw new Exception("Pauta não encontrada");
        return repository.save( sessaoVotacao );
    }

    @Override
    public Page<SessaoVotacao> findAll(Pageable pageable) {
        return repository.findAll(pageable);
    }

    @Override
    public ResponseEntity delete(String id) {
        repository.deleteById( id );
        return ResponseEntity.noContent().build();
    }

    public Optional<SessaoVotacao> findById(String id) {
        return repository.findById( id );
    }

    @Override
    public SessaoVotacao update(SessaoVotacao sessaoVotacao) {
        return repository.save( sessaoVotacao );
    }
}
