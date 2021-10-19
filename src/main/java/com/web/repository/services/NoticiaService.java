package com.web.repository.services;

import java.util.List;

import com.web.entities.Noticia;

public interface NoticiaService {

	public Noticia save(Noticia n);
	public String remove(int id);
	public List<Noticia> findAll();
	public Noticia findById(int id);
	
}
