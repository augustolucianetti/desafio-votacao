package br.com.augusto.desafiovotacao.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Voto {

    @Id
    private String id;

    private boolean voto;

    private Associado associado;

    private SessaoVotacao sessaoVotacao;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public boolean isVoto() {
        return voto;
    }

    public void setVoto(boolean voto) {
        this.voto = voto;
    }

    public Associado getAssociado() {
        return associado;

    }

    public void setAssociado(Associado associado) {
        this.associado = associado;
    }

    public SessaoVotacao getSessaoVotacao() {
        return sessaoVotacao;
    }

    public void setSessaoVotacao(SessaoVotacao sessaoVotacao) {
        this.sessaoVotacao = sessaoVotacao;
    }
}
