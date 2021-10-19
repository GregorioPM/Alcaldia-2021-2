package com.web.entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the enlace_interes database table.
 * 
 */
@Entity
@Table(name="enlace_interes")
@NamedQuery(name="EnlaceIntere.findAll", query="SELECT e FROM EnlaceIntere e")
public class EnlaceIntere implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_enlace_interes")
	private int idEnlaceInteres;

	private String titulo;

	private String url;

	//bi-directional many-to-one association to Alcaldia
	@ManyToOne
	@JoinColumn(name="id_alcaldia")
	private Alcaldia alcaldia;

	public EnlaceIntere() {
	}

	public int getIdEnlaceInteres() {
		return this.idEnlaceInteres;
	}

	public void setIdEnlaceInteres(int idEnlaceInteres) {
		this.idEnlaceInteres = idEnlaceInteres;
	}

	public String getTitulo() {
		return this.titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getUrl() {
		return this.url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public Alcaldia getAlcaldia() {
		return this.alcaldia;
	}

	public void setAlcaldia(Alcaldia alcaldia) {
		this.alcaldia = alcaldia;
	}

}