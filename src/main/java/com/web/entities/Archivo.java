package com.web.entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the archivo database table.
 * 
 */
@Entity
@Table(name="archivo")
@NamedQuery(name="Archivo.findAll", query="SELECT a FROM Archivo a")
public class Archivo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_archivo")
	private int idArchivo;

	private String data;

	private String nombre;

	private String tipo;

	public Archivo() {
	}

	public int getIdArchivo() {
		return this.idArchivo;
	}

	public void setIdArchivo(int idArchivo) {
		this.idArchivo = idArchivo;
	}

	public String getData() {
		return this.data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getTipo() {
		return this.tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

}