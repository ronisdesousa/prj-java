package com.agenda.agenda.service;

import com.agenda.agenda.domain.model.Procedimento;

public interface ProcedimentoService {
    Procedimento findById(Long id);

    Procedimento create(Procedimento procedimento);
}
