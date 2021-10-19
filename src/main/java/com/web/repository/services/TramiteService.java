package com.web.repository.services;

import java.util.List;

import com.web.entities.Paso;
import com.web.entities.Tramite;

public interface TramiteService {

	public Tramite findByid(int id);
	public List<Tramite> listarPerteneciente(int user);
	public Tramite save(Tramite tramite);
	public void deleteById(int id);
	public List<Tramite> listarAll();
	
	public List<Paso> getPasos(int id);
	public Paso save(Paso paso);
	public void deletePaso(int id);
	public Paso findById(int id);
	
}
