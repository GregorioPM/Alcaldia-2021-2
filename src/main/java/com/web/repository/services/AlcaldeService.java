package com.web.repository.services;

import com.web.entities.Alcalde;

import java.util.List;

public interface AlcaldeService {

    public Alcalde save(Alcalde alcalde);
    Alcalde update(Alcalde alcalde);
    public String remove(int id);
    public List<Alcalde> findAll();
    public Alcalde findById(int id);

}
