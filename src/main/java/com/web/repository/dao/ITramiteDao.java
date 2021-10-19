package com.web.repository.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.web.entities.Tramite;

public interface ITramiteDao extends CrudRepository<Tramite, Integer> {
@Query("select t from Tramite t join fetch t.alcaldia a where a.idAlcaldia=?1")
public List<Tramite> listar(int id);
}
