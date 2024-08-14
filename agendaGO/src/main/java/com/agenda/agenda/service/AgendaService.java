package com.agenda.agenda.service;

import java.util.List;

import com.agenda.agenda.domain.model.Agenda;

public interface AgendaService {
    Agenda findById(Long id);

    List<Agenda> findByClienteId(Long clienteId);
    
    List<Agenda> findToday();

    Agenda create(Agenda agenda);

    Boolean delete(Long id);
}
