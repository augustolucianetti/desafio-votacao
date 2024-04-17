package br.com.augusto.desafiovotacao.dto;

import br.com.augusto.desafiovotacao.model.Pauta;
import br.com.augusto.desafiovotacao.model.SessaoVotacao;

public class ResultadoVotacaoDTO {

    private Pauta pauta;

    private SessaoVotacao sessaoVotacao;

    private int quantidadeVotosSim;

    private int quantidadeVotosNao;

    private int totalVotos;

    private boolean aprovado;

    public Pauta getPauta() {
        return pauta;
    }

    public void setPauta(Pauta pauta) {
        this.pauta = pauta;
    }

    public SessaoVotacao getSessaoVotacao() {
        return sessaoVotacao;
    }

    public void setSessaoVotacao(SessaoVotacao sessaoVotacao) {
        this.sessaoVotacao = sessaoVotacao;
    }

    public int getQuantidadeVotosSim() {
        return quantidadeVotosSim;
    }

    public void setQuantidadeVotosSim(int quantidadeVotosSim) {
        this.quantidadeVotosSim = quantidadeVotosSim;
    }

    public int getQuantidadeVotosNao() {
        return quantidadeVotosNao;
    }

    public void setQuantidadeVotosNao(int quantidadeVotosNao) {
        this.quantidadeVotosNao = quantidadeVotosNao;
    }

    public int getTotalVotos() {
        return totalVotos;
    }

    public void setTotalVotos(int totalVotos) {
        this.totalVotos = totalVotos;
    }

    public boolean isAprovado() {
        return aprovado;
    }

    public void setAprovado(boolean aprovado) {
        this.aprovado = aprovado;
    }
}
