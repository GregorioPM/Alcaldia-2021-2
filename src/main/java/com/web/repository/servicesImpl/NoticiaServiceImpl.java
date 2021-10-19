package com.web.repository.servicesImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.web.entities.Noticia;
import com.web.repository.dao.INoticiaDao;
import com.web.repository.services.NoticiaService;

@Service
public class NoticiaServiceImpl implements NoticiaService {

	@Autowired
	private INoticiaDao noticiasDao;
	
	@Override
	public Noticia save(Noticia noticia) {
		try {
			return noticiasDao.save(noticia);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return null;
	}
	
	@Override
	public String remove(int id) {
		try {
			noticiasDao.deleteById(id);
			return "Noticia eliminada";
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return null;
	}
	
	@Override
	public List<Noticia> findAll() {
		try {
			return (List<Noticia>)noticiasDao.findAll();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return null;
	}
	
	@Override
	public Noticia findById(int id) {
		try {
			return noticiasDao.findById(id).orElse(null);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return null;
	}

	

}
