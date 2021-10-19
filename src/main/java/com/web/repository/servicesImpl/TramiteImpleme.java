package com.web.repository.servicesImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.web.entities.Paso;
import com.web.entities.Tramite;
import com.web.repository.dao.IPasoDao;
import com.web.repository.dao.ITramiteDao;
import com.web.repository.services.TramiteService;

@Service
public class TramiteImpleme implements TramiteService {

	
	@Autowired
	private IPasoDao paso;
	
	@Autowired
	private ITramiteDao tramite;
	
	@Override
	public Tramite findByid(int id) {
	 return this.tramite.findById(id).orElse(null);
	}

	@Override
	public List<Tramite> listarPerteneciente(int user) {
		// TODO Auto-generated method stub
		return this.tramite.listar(user);
	}

	@Override
	public Tramite save(Tramite tramite) {
		// TODO Auto-generated method stub
		return this.tramite.save(tramite);
	}

	@Override
	public void deleteById(int id) {
		this.tramite.deleteById(id);
	}

	@Override
	public List<Paso> getPasos(int id) {
		return this.paso.pasosByIDTramite(id);
	}

	@Override
	public Paso save(Paso paso) {
		return this.paso.save(paso);
	}


	@Override
	public void deletePaso(int id) {
		this.paso.deleteById(id);
		
	}

	@Override
	public Paso findById(int id) {
		return this.paso.findById(id).orElse(null);
	}

	@Override
	public List<Tramite> listarAll() {
		return (List<Tramite>)this.tramite.findAll();
	}

}
