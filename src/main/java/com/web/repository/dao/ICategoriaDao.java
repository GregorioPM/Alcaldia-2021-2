package com.web.repository.dao;



import org.springframework.data.repository.CrudRepository;

import com.web.entities.Categoria;

//KEVIN ENRIQUE JIMENEZ SANCHEZ COD:1151652


public interface ICategoriaDao extends CrudRepository<Categoria, Integer> {

	public Categoria findById(int idcategoria);

}
