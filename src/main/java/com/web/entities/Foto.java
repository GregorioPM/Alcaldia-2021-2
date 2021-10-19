package com.web.entities;

import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;


/**
 * The persistent class for the foto database table.
 * 
 */
@Entity
@Table(name="foto")
@NamedQuery(name="Foto.findAll", query="SELECT f FROM Foto f")
public class Foto implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_foto")
	private int idFoto;

	private String descripcion;

	//bi-directional many-to-one association to Usuario
	@ManyToOne
	@JsonIgnore
	@JoinColumn(name="usuario")
	private Usuario usuario;
	
	//bi-directional many-to-one association to Noticia
	@ManyToOne
	@JsonIgnore
	@JoinColumn(name="id_noticia")
	private Noticia noticia;

	public Foto() {
	}

	public int getIdFoto() {
		return this.idFoto;
	}

	public void setIdFoto(int idFoto) {
		this.idFoto = idFoto;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}


	public Usuario getUsuario() {
		return this.usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Noticia getNoticia() {
		return noticia;
	}

	public void setNoticia(Noticia noticia) {
		this.noticia = noticia;
	}

}