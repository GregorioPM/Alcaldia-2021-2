package com.web.repository.servicesImpl;

import java.util.ArrayList;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.web.entities.Categoria;
import com.web.repository.dao.ICategoriaDao;
import com.web.repository.services.CategoriaService;


//KEVIN ENRIQUE JIMENEZ SANCHEZ COD:1151652

@Service
public class CategoriaServiceImpl implements CategoriaService {
	Logger logger = LoggerFactory.getLogger(CategoriaServiceImpl.class);

	@Autowired
	private ICategoriaDao repository;

	@Override
	public Categoria save(Categoria entity) {
		try {
			
			
			return repository.save(entity);
		} catch (Exception e) {
			logger.error("Registrar categorias", e);
		}
		return null;
	}

	


	@Override
	public List<Categoria> findAll() {
		try {
			return (List<Categoria>) repository.findAll();
		} catch (Exception e) {
			logger.error("Listar categorias", e);
		}
		return new ArrayList<>();
	}




	@Override
	public Categoria findById(int idcategoria) {
		try {
			return repository.findById(idcategoria);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	@Override
	public String remove(int id) {
		try {
			repository.deleteById(id);
			return "Categoria eliminada";
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}




	

	

}
