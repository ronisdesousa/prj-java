package com.agenda.agenda.service;

import com.agenda.agenda.domain.model.Cliente;

public interface ClienteService {
    Cliente findById(Long id);

    Cliente create(Cliente cliente);
}
