package com.web.repository.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.web.entities.Paso;

public interface IPasoDao extends CrudRepository<Paso, Integer> {

	@Query("select p from Paso p join fetch p.tramite t where t.idTramite=?1")
	public List<Paso> pasosByIDTramite(int id);
}
