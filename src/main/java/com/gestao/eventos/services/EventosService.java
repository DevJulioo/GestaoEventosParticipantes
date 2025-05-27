package com.gestao.eventos.services;

import com.gestao.eventos.dtos.EventosDTO;
import com.gestao.eventos.entities.Eventos;
import com.gestao.eventos.repositories.EventosRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EventosService {

    @Autowired
    private EventosRepository eventosRepository;

    @Transactional(readOnly = true)
    public List<EventosDTO> findAll() {
        List<Eventos> eventos = eventosRepository.findAll();
        return eventos.stream().map(EventosDTO::new).collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public EventosDTO findById(Long id) {
        Eventos evento = eventosRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Evento não encontrado"));
        return new EventosDTO(evento);
    }

    @Transactional
    public EventosDTO create(EventosDTO dto) {
        if (dto.getVagas() <= 0) {
            throw new IllegalArgumentException("O número de vagas deve ser maior que zero");
        }
        if (dto.getVagas() > Eventos.LIMITE_MAXIMO_VAGAS) {
            throw new IllegalArgumentException("O número de vagas não pode exceder " + Eventos.LIMITE_MAXIMO_VAGAS);
        }

        Eventos evento = new Eventos();
        copyDtoToEntity(dto, evento);
        evento = eventosRepository.save(evento);
        return new EventosDTO(evento);
    }

    private void copyDtoToEntity(EventosDTO dto, Eventos evento) {
        evento.setNome(dto.getNome());
        evento.setDescricao(dto.getDescricao());
        evento.setData(dto.getData().toLocalDate());
        evento.setLocal(dto.getLocal());
        evento.setVagas(dto.getVagas());
    }
}