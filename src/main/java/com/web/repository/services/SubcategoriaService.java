package com.web.repository.services;

import java.util.List;

import com.web.entities.Categoria;
import com.web.entities.SubCategoria;


//KEVIN ENRIQUE JIMENEZ SANCHEZ COD:1151652



public interface SubcategoriaService {

	public List<SubCategoria> findAll();

	public SubCategoria save(SubCategoria entity);
	
	public SubCategoria findById(int idsubcategoria);

	public List<SubCategoria> findByCategoria(Categoria categoria);

	public String remove(int id);

}
