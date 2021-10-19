package com.web.repository.services;

import com.web.entities.Foto;

public interface FotoService{

	public Foto save(Foto foto);
	public String remove(int id);
}
