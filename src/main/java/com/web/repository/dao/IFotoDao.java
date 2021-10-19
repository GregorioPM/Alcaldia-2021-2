package com.web.repository.dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.web.entities.Foto;

public interface IFotoDao extends CrudRepository<Foto, Integer> {

	//@Query("delete from Foto f where f.id=?1")
	//public void deleteImagen(int id);
}
