package com.gestao.eventos.repositories;

import com.gestao.eventos.entities.Eventos;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EventosRepository extends JpaRepository<Eventos, Long> {
}
