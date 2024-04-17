package br.com.augusto.desafiovotacao.dto;

import java.time.LocalDateTime;

public class SessaoVotacaoDTO {

    private LocalDateTime startDate;

    private LocalDateTime endDate;

    private String idPauta;

    public LocalDateTime getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDateTime startDate) {
        this.startDate = startDate;
    }

    public LocalDateTime getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDateTime endDate) {
        this.endDate = endDate;
    }

    public String getIdPauta() {
        return idPauta;
    }

    public void setIdPauta(String idPauta) {
        this.idPauta = idPauta;
    }
}
