package com.web.repository.services;

import java.util.List;

import com.web.entities.Alcaldia;

//KEVIN ENRIQUE JIMENEZ SANCHEZ COD:1151652 

public interface AlcaldiaService {

	public Alcaldia guardar(Alcaldia entity);

	public Alcaldia findById(Integer id);
	
	public List<Alcaldia> findAll();
	
	public String remove(int id);

}
