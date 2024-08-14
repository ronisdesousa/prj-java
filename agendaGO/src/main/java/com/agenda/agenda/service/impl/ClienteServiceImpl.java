package com.agenda.agenda.service.impl;

import java.util.NoSuchElementException;

import org.springframework.stereotype.Service;

import com.agenda.agenda.domain.model.Cliente;
import com.agenda.agenda.domain.repository.ClienteRepository;
import com.agenda.agenda.service.ClienteService;

@Service
public class ClienteServiceImpl implements ClienteService {
    private final ClienteRepository _clienteRepository;

    public ClienteServiceImpl(ClienteRepository clienteRepository) {
        this._clienteRepository = clienteRepository;
    }

    @Override
    public Cliente findById(Long id) {
        return _clienteRepository.findById(id).orElseThrow(NoSuchElementException::new);
    }

    @Override
    public Cliente create(Cliente cliente) {
        return _clienteRepository.save(cliente);
    }

}
