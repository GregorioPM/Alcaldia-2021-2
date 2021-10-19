package com.web.repository.dao;

import org.springframework.data.repository.CrudRepository;

import com.web.entities.Alcaldia;

//KEVIN ENRIQUE JIMENEZ SANCHEZ COD:1151652 




public interface IAlcaldiaDao extends CrudRepository<Alcaldia, Integer>{

	public Alcaldia findById(int idalcalida);
}
