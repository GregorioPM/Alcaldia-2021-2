package com.web.repository.servicesImpl;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.web.entities.Alcaldia;
import com.web.entities.Usuario;
import com.web.repository.dao.IUsuarioDao;
import com.web.repository.services.UsuarioService;

@Service
public class UserServiceImpl implements UsuarioService{
	
	Logger logger = LoggerFactory.getLogger(AlcaldiaServiceImpl.class);

	@Autowired
	private IUsuarioDao userDao;
	
	@Override
	@Transactional
	public Usuario save(Usuario usuario) {
		// TODO Auto-generated method stub
		return userDao.save(usuario);
	}

	@Override
	public Usuario findByEmail(String email) {
		try {
			return userDao.findByEmail(email);
		} catch (Exception e) {
			logger.error("Busqueda usuario por email", e);
		}
		return null;
	}

	@Override
	public List<Usuario> findAll() {
		try {
			return (List<Usuario>) userDao.findAll();
		} catch (Exception e) {
			logger.error("Listar usuarios", e);
		}
		return new ArrayList<>();
	}
	

}
