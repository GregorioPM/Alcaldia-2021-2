package com.web.entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the pregunta_frecuente database table.
 * 
 */
@Entity
@Table(name="pregunta_frecuente")
@NamedQuery(name="PreguntaFrecuente.findAll", query="SELECT p FROM PreguntaFrecuente p")
public class PreguntaFrecuente implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_pregunta_frecuente")
	private int idPreguntaFrecuente;

	private String pregunta;

	private String respuesta;

	//bi-directional many-to-one association to Alcaldia
	@ManyToOne
	@JoinColumn(name="id_alcaldia")
	private Alcaldia alcaldia;

	public PreguntaFrecuente() {
	}

	public int getIdPreguntaFrecuente() {
		return this.idPreguntaFrecuente;
	}

	public void setIdPreguntaFrecuente(int idPreguntaFrecuente) {
		this.idPreguntaFrecuente = idPreguntaFrecuente;
	}

	public String getPregunta() {
		return this.pregunta;
	}

	public void setPregunta(String pregunta) {
		this.pregunta = pregunta;
	}

	public String getRespuesta() {
		return this.respuesta;
	}

	public void setRespuesta(String respuesta) {
		this.respuesta = respuesta;
	}

	public Alcaldia getAlcaldia() {
		return this.alcaldia;
	}

	public void setAlcaldia(Alcaldia alcaldia) {
		this.alcaldia = alcaldia;
	}

}