package com.agenda.agenda.controller;

import java.net.URI;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.agenda.agenda.domain.model.Agenda;
import com.agenda.agenda.service.AgendaService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
@RequestMapping("/agenda")
public class AgendaController {
    private final AgendaService _agendaService;

    public AgendaController(AgendaService agendaService) {
        this._agendaService = agendaService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Agenda> findById(@PathVariable Long id) {
        var agenda = _agendaService.findById(id);
        return ResponseEntity.ok(agenda);
    }

    @GetMapping("/cliente/{clienteId}")
    public ResponseEntity<List<Agenda>> findByClienteId(@PathVariable Long clienteId) {
        var agenda = _agendaService.findByClienteId(clienteId);
        return ResponseEntity.ok(agenda);
    }

    @GetMapping("/today")
    public ResponseEntity<List<Agenda>> findToday() {
        var agenda = _agendaService.findToday();
        return ResponseEntity.ok(agenda);
    }

    @PostMapping
    public ResponseEntity<Agenda> create(@RequestBody Agenda agenda) {
        var agendaCreated = _agendaService.create(agenda);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(agendaCreated.getId())
                .toUri();
        return ResponseEntity.created(location).body(agendaCreated);
    }

    @DeleteMapping
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        var result = _agendaService.delete(id);
        return result ? ResponseEntity.noContent().build() : ResponseEntity.notFound().build();
    }
}
