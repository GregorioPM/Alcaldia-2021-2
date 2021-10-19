package com.web.entities;

import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.List;


/**
 * The persistent class for the usuario database table.
 * 
 */
@Entity
@Table(name="usuario")
@NamedQuery(name="Usuario.findAll", query="SELECT u FROM Usuario u")
public class Usuario implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String email;

	private String apellidos;

	private String password;

	private String nombre;
	
	private String rol;

	//bi-directional many-to-one association to Noticia
//	@JsonBackReference
	@OneToMany(mappedBy="usuario")
	private List<Noticia> noticias;

	//bi-directional many-to-one association to Alcaldia
	@ManyToOne
	@JoinColumn(name="id_alcaldia")
	@JsonIgnore
	private Alcaldia alcaldia;

	public Usuario() {
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}



	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getApellidos() {
		return this.apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRol() {
		return this.rol;
	}

	public void setRol(String rol) {
		this.rol = rol;
	}

	public List<Noticia> getNoticias() {
		return this.noticias;
	}

	public void setNoticias(List<Noticia> noticias) {
		this.noticias = noticias;
	}

	public Noticia addNoticia(Noticia noticia) {
		getNoticias().add(noticia);
		noticia.setUsuario(this);

		return noticia;
	}

	public Noticia removeNoticia(Noticia noticia) {
		getNoticias().remove(noticia);
		noticia.setUsuario(null);

		return noticia;
	}

	public Alcaldia getAlcaldia() {
		return this.alcaldia;
	}

	public void setAlcaldia(Alcaldia alcaldia) {
		this.alcaldia = alcaldia;
	}

}