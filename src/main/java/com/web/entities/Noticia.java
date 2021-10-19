package com.web.entities;

import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.Date;
import java.util.List;


/**
 * The persistent class for the noticia database table.
 * 
 */
@Entity
@Table(name="noticia")
@NamedQuery(name="Noticia.findAll", query="SELECT n FROM Noticia n")
public class Noticia implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_noticia")
	private int idNoticia;

	private String descripcion;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="fecha_creacion")
	private Date fechaCreacion;

	private String titulo;

	//bi-directional many-to-one association to Alcaldia
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name="id_alcaldia")
	private Alcaldia alcaldia;

	//bi-directional many-to-one association to SubCategoria
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name="sub_categoria_id")
	private SubCategoria subCategoria;
	
	//bi-directional many-to-one association to Foto
	@OneToMany(mappedBy="noticia", fetch = FetchType.EAGER)
	private List<Foto> fotos;

	//bi-directional many-to-one association to Usuario
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name="usuario")
	private Usuario usuario;

	public Noticia() {
	}

	public int getIdNoticia() {
		return this.idNoticia;
	}

	public void setIdNoticia(int idNoticia) {
		this.idNoticia = idNoticia;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Date getFechaCreacion() {
		return this.fechaCreacion;
	}

	public void setFechaCreacion(Date fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	public String getTitulo() {
		return this.titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public Alcaldia getAlcaldia() {
		return this.alcaldia;
	}

	public void setAlcaldia(Alcaldia alcaldia) {
		this.alcaldia = alcaldia;
	}

	public SubCategoria getSubCategoria() {
		return this.subCategoria;
	}

	public void setSubCategoria(SubCategoria subCategoria) {
		this.subCategoria = subCategoria;
	}

	public Usuario getUsuario() {
		return this.usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public List<Foto> getFotos() {
		return fotos;
	}

	public void setFotos(List<Foto> fotos) {
		this.fotos = fotos;
	}

}