package com.gestao.eventos.controllers;

import com.gestao.eventos.dtos.EventosDTO;
import com.gestao.eventos.services.EventosService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/eventos")
public class EventosController {

    @Autowired
    private EventosService eventosService;

    @GetMapping
    public ResponseEntity<List<EventosDTO>> findAll() {
        List<EventosDTO> list = eventosService.findAll();
        return ResponseEntity.ok(list);
    }

    @GetMapping("/{id}")
    public ResponseEntity<EventosDTO> findById(@PathVariable Long id) {
        EventosDTO dto = eventosService.findById(id);
        return ResponseEntity.ok(dto);
    }

    @PostMapping
    public ResponseEntity<EventosDTO> create(@Valid @RequestBody EventosDTO dto) {
        dto = eventosService.create(dto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(dto.getId()).toUri();
        return ResponseEntity.created(uri).body(dto);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handleException(Exception e) {
        return ResponseEntity.badRequest().body(e.getMessage());
    }
}
