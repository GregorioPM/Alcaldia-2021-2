package com.web.repository.servicesImpl;

import java.util.ArrayList;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.web.entities.Categoria;
import com.web.entities.SubCategoria;
import com.web.repository.dao.ISubcategoriaDao;
import com.web.repository.services.SubcategoriaService;

//KEVIN ENRIQUE JIMENEZ SANCHEZ COD:1151652


@Service
public class SubcategoriaServiceImpl implements SubcategoriaService {
	Logger logger = LoggerFactory.getLogger(SubcategoriaServiceImpl.class);

	@Autowired
	private ISubcategoriaDao repository;

	@Override
	public SubCategoria save(SubCategoria entity) {
		try {
			
			
			return repository.save(entity);
		} catch (Exception e) {
			logger.error("Registrar subcategorias", e);
		}
		return null;
	}

	


	@Override
	public List<SubCategoria> findAll() {
		try {
			return (List<SubCategoria>) repository.findAll();
		} catch (Exception e) {
			logger.error("Listar subcategorias", e);
		}
		return new ArrayList<>();
	}




	@Override
	public SubCategoria findById(int idsubcategoria) {
		try {
			return repository.findById(idsubcategoria);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	@Override
	public List<SubCategoria> findByCategoria(Categoria categoria) {
		try {
			return repository.findByCategoria(categoria);
		} catch (Exception e) {
			logger.error("Listar las subcategorias por categoria", e);
		}
		return new ArrayList<>();
	}

	@Override
	public String remove(int id) {
		try {
			repository.deleteById(id);
			return "SubCategoria eliminada";
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}



	

	

}
