package com.web.entities;

import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;


/**
 * The persistent class for the paso database table.
 * 
 */
@Entity
@Table(name="paso")
@NamedQuery(name="Paso.findAll", query="SELECT p FROM Paso p")
public class Paso implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_paso")
	private int idPaso;

	private String descripcion;

	private String numero;

	private String titulo;

	//bi-directional many-to-one association to Tramite
	@ManyToOne
	@JoinColumn(name="id_tramite")
	@JsonIgnore
	private Tramite tramite;

	public Paso() {
	}

	public int getIdPaso() {
		return this.idPaso;
	}

	public void setIdPaso(int idPaso) {
		this.idPaso = idPaso;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getNumero() {
		return this.numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getTitulo() {
		return this.titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public Tramite getTramite() {
		return this.tramite;
	}

	public void setTramite(Tramite tramite) {
		this.tramite = tramite;
	}

}