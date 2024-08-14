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

import com.agenda.agenda.domain.model.Procedimento;
import com.agenda.agenda.service.ProcedimentoService;

@RestController
@RequestMapping("/procedimentos")
public class ProcedimentoController {
    private final ProcedimentoService _procedimentoService;

    public ProcedimentoController(ProcedimentoService procedimentoService) {
        this._procedimentoService = procedimentoService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Procedimento> findById(@PathVariable Long id) {
       var procedimento = _procedimentoService.findById(id);
       return ResponseEntity.ok(procedimento);
    }

    @PostMapping
    public ResponseEntity<Procedimento> create(@RequestBody Procedimento procedimento) {
        var procedimentoCreated = _procedimentoService.create(procedimento);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(procedimentoCreated.getId())
                .toUri();
        return ResponseEntity.created(location).body(procedimentoCreated);
    }
}
