package com.web.repository.services;

import java.util.List;
import com.web.entities.Usuario;

public interface UsuarioService{
	
	public Usuario save(Usuario usuario);
//	@Query("select u from User u where u.email='?1'")
	public Usuario findByEmail(String email);
	public List<Usuario> findAll();
	
}
