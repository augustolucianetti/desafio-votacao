package br.com.augusto.desafiovotacao.service.impl;

import br.com.augusto.desafiovotacao.dto.ResultadoVotacaoDTO;
import br.com.augusto.desafiovotacao.dto.VotoDTO;
import br.com.augusto.desafiovotacao.model.Associado;
import br.com.augusto.desafiovotacao.model.SessaoVotacao;
import br.com.augusto.desafiovotacao.model.Voto;
import br.com.augusto.desafiovotacao.repository.VotoRepositoy;
import br.com.augusto.desafiovotacao.service.AssociadoService;
import br.com.augusto.desafiovotacao.service.SessaoVotacaoService;
import br.com.augusto.desafiovotacao.service.VotoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class VotoServiceImpl implements VotoService {

    @Autowired
    private VotoRepositoy repositoy;

    @Autowired
    private SessaoVotacaoService sessaoVotacaoService;

    @Autowired
    private AssociadoService associadoService;

    @Override
    public Voto save(VotoDTO votoDTO) {

        Optional<SessaoVotacao> sessaoVotacao = sessaoVotacaoService.findById( votoDTO.getSessaoVotacaoId() );
        if (!sessaoVotacao.isPresent())
            throw new RuntimeException("Sessão não encontrada");

        Optional<Associado> associado = associadoService.findById( votoDTO.getAssociadoId() );
        if (!associado.isPresent())
            throw new RuntimeException("Associado não encontrado");

        Voto voto = new Voto();
        voto.setSessaoVotacao( sessaoVotacao.get() );
        voto.setVoto( votoDTO.isVoto() );
        voto.setAssociado( associado.get() );

        Voto votoSaved = repositoy.save( voto );
        //Fim salvando votos
        return votoSaved;
    }

    @Override
    public Page<Voto> getAll(Pageable pageable) {
        return null;
    }

    @Override
    public ResponseEntity delete(String id) {
        return null;
    }

    @Override
    public Page<Voto> findAllBySessaoVotacaoId(String id, Pageable pageable) {
        return repositoy.findAllBySessaoVotacao_Id( id, pageable );
    }

    @Override
    public ResultadoVotacaoDTO getResultadoVotacao(String sessaoId, String pautaId) throws Exception {

        List<Voto> votos = repositoy.findAllBySessaoVotacaoIdAndSessaoVotacaoPautaId( sessaoId, pautaId );
        if (votos != null && votos.size() > 0) {
            ResultadoVotacaoDTO resultado = new ResultadoVotacaoDTO();
            resultado.setSessaoVotacao( votos.get( 0 ).getSessaoVotacao() );
            resultado.setPauta( votos.get( 0 ).getSessaoVotacao().getPauta() );
            resultado.setTotalVotos( votos.size() );

            for (Voto item : votos) {

                if (item.isVoto())
                    resultado.setQuantidadeVotosSim( resultado.getQuantidadeVotosSim() + 1 );
                else
                    resultado.setQuantidadeVotosNao( resultado.getQuantidadeVotosNao() + 1 );
            }

            if (resultado.getQuantidadeVotosNao() > resultado.getQuantidadeVotosSim())
                resultado.setAprovado( false );
            else
                resultado.setAprovado( true );

            return resultado;
        } else {
            throw new Exception("Ainda não existem votos para serem contabilizados");
        }

    }
}
