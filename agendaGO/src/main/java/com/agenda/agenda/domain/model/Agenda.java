package com.agenda.agenda.domain.model;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity(name="agenda")
public class Agenda {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long clienteId;
    private Long procedimentoId;
    private Date dataHorario;
    private String observacao;

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public Long getClienteId() {
        return clienteId;
    }
    public void setClienteId(Long clienteId) {
        this.clienteId = clienteId;
    }
    public Long getProcedimentoId() {
        return procedimentoId;
    }
    public void setProcedimentoId(Long procedimentoId) {
        this.procedimentoId = procedimentoId;
    }
    public Date getDataHorario() {
        return dataHorario;
    }
    public void setDataHorario(Date dataHorario) {
        this.dataHorario = dataHorario;
    }
    public String getObservacao() {
        return observacao;
    }
    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }
}
