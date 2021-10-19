package com.web.repository.servicesImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.web.entities.Foto;
import com.web.repository.dao.IFotoDao;
import com.web.repository.services.FotoService;

@Service
public class FotoServiceImpl implements FotoService {

	@Autowired
	IFotoDao fotoDao;
	
	@Override
	public Foto save(Foto foto) {
		try {
			return fotoDao.save(foto);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}

	@Override
	public String remove(int id) {
		try {
			fotoDao.deleteById(id);
			return "Imagen eliminada";
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return null;
	}
	
	

}
