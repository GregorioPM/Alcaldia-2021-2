package com.web.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the categoria database table.
 * 
 */
@Entity
@Table(name="categoria")
@NamedQuery(name="Categoria.findAll", query="SELECT c FROM Categoria c")
public class Categoria implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_categoria")
	private int idCategoria;

	private String descripcion;

	private String orden;

	private String titulo;

	//bi-directional many-to-one association to SubCategoria
	@OneToMany(mappedBy="categoria")
	private List<SubCategoria> subCategorias;

	public Categoria() {
	}

	public int getIdCategoria() {
		return this.idCategoria;
	}

	public void setIdCategoria(int idCategoria) {
		this.idCategoria = idCategoria;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getOrden() {
		return this.orden;
	}

	public void setOrden(String orden) {
		this.orden = orden;
	}

	public String getTitulo() {
		return this.titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public List<SubCategoria> getSubCategorias() {
		return this.subCategorias;
	}

	public void setSubCategorias(List<SubCategoria> subCategorias) {
		this.subCategorias = subCategorias;
	}

	public SubCategoria addSubCategoria(SubCategoria subCategoria) {
		getSubCategorias().add(subCategoria);
		subCategoria.setCategoria(this);

		return subCategoria;
	}

	public SubCategoria removeSubCategoria(SubCategoria subCategoria) {
		getSubCategorias().remove(subCategoria);
		subCategoria.setCategoria(null);

		return subCategoria;
	}

}