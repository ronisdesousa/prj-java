package com.agenda.agenda.service.impl;

import java.util.NoSuchElementException;

import org.springframework.stereotype.Service;

import com.agenda.agenda.domain.model.Procedimento;
import com.agenda.agenda.domain.repository.ProcedimentoRepository;
import com.agenda.agenda.service.ProcedimentoService;

@Service
public class ProcedimentoServiceImpl implements ProcedimentoService{
    private final ProcedimentoRepository _procedimentoRepository;

    public ProcedimentoServiceImpl(ProcedimentoRepository procedimentoRepository) {
        this._procedimentoRepository = procedimentoRepository;
    }

    @Override
    public Procedimento findById(Long id) {
        return _procedimentoRepository.findById(id).orElseThrow(NoSuchElementException::new);
    }

    @Override
    public Procedimento create(Procedimento procedimento) {
        /*if (procedimento.getNome() == null || "".equals(procedimento.getNome())) {
            throw new IllegalArgumentException("Nome não informado!");
        }*/

        return _procedimentoRepository.save(procedimento);
    }

}
