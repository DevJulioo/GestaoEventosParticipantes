package com.gestao.eventos.controllers;

import com.gestao.eventos.dtos.ParticipantesDTO;
import com.gestao.eventos.services.ParticipantesService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/participantes")
public class ParticipantesController {

    @Autowired
    private ParticipantesService participantesService;

    @GetMapping
    public ResponseEntity<List<ParticipantesDTO>> findAll() {
        List<ParticipantesDTO> list = participantesService.findAll();
        return ResponseEntity.ok(list);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ParticipantesDTO> findById(@PathVariable Long id) {
        ParticipantesDTO dto = participantesService.findById(id);
        return ResponseEntity.ok(dto);
    }

    @PostMapping
    public ResponseEntity<ParticipantesDTO> create(@Valid @RequestBody ParticipantesDTO dto) {
        dto = participantesService.create(dto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(dto.getId()).toUri();
        return ResponseEntity.created(uri).body(dto);
    }

    @PostMapping("/{participanteId}/inscrever/{eventoId}")
    public ResponseEntity<Void> inscreverEmEvento(
            @PathVariable Long participanteId,
            @PathVariable Long eventoId) {
        participantesService.inscreverEmEvento(participanteId, eventoId);
        return ResponseEntity.ok().build();
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handleException(Exception e) {
        return ResponseEntity.badRequest().body(e.getMessage());
    }
}
