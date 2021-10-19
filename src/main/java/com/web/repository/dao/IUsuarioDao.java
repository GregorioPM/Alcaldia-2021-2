package com.web.repository.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.web.entities.Usuario;

@Repository
public interface IUsuarioDao extends JpaRepository<Usuario, Integer>{
    @Query("select u from Usuario u where u.email=?1")
	public Usuario findByEmail(String email);
}
