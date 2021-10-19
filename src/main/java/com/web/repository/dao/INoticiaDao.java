package com.web.repository.dao;

import org.springframework.data.repository.CrudRepository;

import com.web.entities.Noticia;

public interface INoticiaDao extends CrudRepository<Noticia, Integer> {

}
