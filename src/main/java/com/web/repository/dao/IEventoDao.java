package com.web.repository.dao;

import com.web.entities.Evento;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IEventoDao extends JpaRepository<Evento,Integer> {
}
