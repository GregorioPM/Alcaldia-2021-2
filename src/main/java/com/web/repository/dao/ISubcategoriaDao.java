package com.web.repository.dao;



import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.web.entities.Categoria;
import com.web.entities.SubCategoria;

//KEVIN ENRIQUE JIMENEZ SANCHEZ COD:1151652


public interface ISubcategoriaDao extends CrudRepository<SubCategoria, Integer> {

	public SubCategoria findById(int idsubcategoria);
	
	public List<SubCategoria> findByCategoria(Categoria categoria);

}
