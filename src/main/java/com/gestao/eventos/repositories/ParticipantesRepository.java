package com.gestao.eventos.repositories;

import com.gestao.eventos.entities.Participantes;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ParticipantesRepository extends JpaRepository<Participantes, Long> {
}
