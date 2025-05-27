package com.gestao.eventos.services;

import com.gestao.eventos.dtos.ParticipantesDTO;
import com.gestao.eventos.entities.Eventos;
import com.gestao.eventos.entities.Participantes;
import com.gestao.eventos.repositories.EventosRepository;
import com.gestao.eventos.repositories.ParticipantesRepository;
import com.gestao.eventos.services.exceptions.EventoException;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ParticipantesService {

    @Autowired
    private ParticipantesRepository participantesRepository;

    @Autowired
    private EventosRepository eventosRepository;

    @Transactional(readOnly = true)
    public List<ParticipantesDTO> findAll() {
        List<Participantes> participantes = participantesRepository.findAll();
        return participantes.stream().map(ParticipantesDTO::new).collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public ParticipantesDTO findById(Long id) {
        Participantes participante = participantesRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Participante não encontrado"));
        return new ParticipantesDTO(participante);
    }

    @Transactional
    public ParticipantesDTO create(ParticipantesDTO dto) {
        Participantes participante = new Participantes();
        copyDtoToEntity(dto, participante);
        participante = participantesRepository.save(participante);
        return new ParticipantesDTO(participante);
    }

    @Transactional
    public void inscreverEmEvento(Long participanteId, Long eventoId) {
        Participantes participante = participantesRepository.findById(participanteId)
                .orElseThrow(() -> new EntityNotFoundException("Participante não encontrado"));

        Eventos evento = eventosRepository.findById(eventoId)
                .orElseThrow(() -> new EntityNotFoundException("Evento não encontrado"));

        int vagasDisponiveis = evento.getVagasDisponiveis();
        if (vagasDisponiveis <= 0) {
            throw new EventoException("Evento lotado! Capacidade máxima de " + evento.getVagas() + " participantes atingida");
        }

        if (evento.getParticipantes().contains(participante)) {
            throw new EventoException("Participante já está inscrito neste evento");
        }

        evento.getParticipantes().add(participante);
        participante.getEventos().add(evento);

        eventosRepository.save(evento);
        participantesRepository.save(participante);
    }

    private void copyDtoToEntity(ParticipantesDTO dto, Participantes participante) {
        participante.setNome(dto.getNome());
        participante.setEmail(dto.getEmail());
        participante.setTelefone(dto.getTelefone());
    }
}