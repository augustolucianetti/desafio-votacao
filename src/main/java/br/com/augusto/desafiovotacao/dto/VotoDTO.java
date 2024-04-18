package br.com.augusto.desafiovotacao.dto;

public class VotoDTO {

    private boolean voto;

    private String associadoId;

    private String sessaoVotacaoId;

    public boolean isVoto() {
        return voto;
    }

    public void setVoto(boolean voto) {
        this.voto = voto;
    }

    public String getAssociadoId() {
        return associadoId;
    }

    public void setAssociadoId(String associadoId) {
        this.associadoId = associadoId;
    }

    public String getSessaoVotacaoId() {
        return sessaoVotacaoId;
    }

    public void setSessaoVotacaoId(String sessaoVotacaoId) {
        this.sessaoVotacaoId = sessaoVotacaoId;
    }
}
