package com.agenda.agenda.controller;

import java.net.URI;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.agenda.agenda.domain.model.Cliente;
import com.agenda.agenda.service.ClienteService;

@RestController
@RequestMapping("/clientes")
public class ClienteController {
    private final ClienteService _clienteService;

    public ClienteController(ClienteService clienteService) {
        this._clienteService = clienteService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Cliente> findById(@PathVariable Long id) {
       var cliente = _clienteService.findById(id);
       return ResponseEntity.ok(cliente);
    }

    @PostMapping
    public ResponseEntity<Cliente> create(@RequestBody Cliente cliente) {
        var clienteCreated = _clienteService.create(cliente);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(clienteCreated.getId())
                .toUri();
        return ResponseEntity.created(location).body(clienteCreated);
    }
}
