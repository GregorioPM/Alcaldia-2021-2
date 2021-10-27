package com.web.repository.services;

import com.web.entities.Evento;

import java.util.List;

public interface IEventoService {

    public Evento save(Evento evento);
    public String remove(int id);
    public List<Evento> findAll();
    public Evento findById(int id);
}
