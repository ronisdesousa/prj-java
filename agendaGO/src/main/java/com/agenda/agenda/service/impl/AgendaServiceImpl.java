package com.agenda.agenda.service.impl;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.stereotype.Service;

import com.agenda.agenda.domain.model.Agenda;
import com.agenda.agenda.domain.repository.AgendaRepository;
import com.agenda.agenda.domain.repository.ClienteRepository;
import com.agenda.agenda.domain.repository.ProcedimentoRepository;
import com.agenda.agenda.service.AgendaService;

@Service
public class AgendaServiceImpl implements AgendaService {
    private final AgendaRepository _agendaRepository;
    private final ClienteRepository _clienteRepository;
    private final ProcedimentoRepository _procedimentoRepository;

    public AgendaServiceImpl(AgendaRepository agendaRepository, ClienteRepository clienteRepository, ProcedimentoRepository procedimentoRepository) {
        this._agendaRepository = agendaRepository;
        this._clienteRepository = clienteRepository;
        this._procedimentoRepository = procedimentoRepository;
    }

    @Override
    public Agenda findById(Long id) {
        return _agendaRepository.findById(id).orElseThrow(NoSuchElementException::new);
    }

    @Override
    public Agenda create(Agenda agenda) {
        if ((agenda.getClienteId() == null) || _clienteRepository.existsById(agenda.getClienteId())) {
            throw new IllegalArgumentException("Cliente não informado ou não existe!");
        }        

        if ((agenda.getProcedimentoId() == null) || _procedimentoRepository.existsById(agenda.getProcedimentoId())) {
            throw new IllegalArgumentException("Procedimento não informado ou não existe!");
        }        

        if (agenda.getDataHorario() == null) {
            throw new IllegalArgumentException("Horário da reserva não informado!");
        }

        return _agendaRepository.save(agenda);
    }

    @Override
    public List<Agenda> findByClienteId(Long clienteId) {
        return _agendaRepository.findByClienteId(clienteId);
    }

    @Override
    public List<Agenda> findToday() {
        return _agendaRepository.findToday();
    }

    @Override
    public Boolean delete(Long id) {
        var agenda = _agendaRepository.findById(id).orElseThrow(NoSuchElementException::new);
        if (agenda == null) return false;
        _agendaRepository.delete(agenda);
        return true;
    }
}
