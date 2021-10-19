package com.web.entities;

import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.List;


/**
 * The persistent class for the alcaldia database table.
 * 
 */
@Entity
@Table(name="alcaldia")
@NamedQuery(name="Alcaldia.findAll", query="SELECT a FROM Alcaldia a")
public class Alcaldia implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_alcaldia")
	private int idAlcaldia;

	private String alcalde;

	private String correo;

	private String direccion;

	@Column(name="horario_atencion")
	private String horarioAtencion;

	private String logo;

	private String nombre;

	private String telefono;

	//bi-directional many-to-one association to EnlaceIntere
	@JsonIgnore
	@OneToMany(mappedBy="alcaldia")
	private List<EnlaceIntere> enlaceInteres;

	//bi-directional many-to-one association to Noticia
	@JsonIgnore
	@OneToMany(mappedBy="alcaldia")
	private List<Noticia> noticias;

	//bi-directional many-to-one association to PreguntaFrecuente
	@JsonIgnore
	@OneToMany(mappedBy="alcaldia")
	private List<PreguntaFrecuente> preguntaFrecuentes;

	//bi-directional many-to-one association to Tramite
	@JsonIgnore
	@OneToMany(mappedBy="alcaldia")
	private List<Tramite> tramites;

	//bi-directional many-to-one association to Usuario
	@JsonIgnore
	@OneToMany(mappedBy="alcaldia")
	private List<Usuario> usuarios;

	public Alcaldia() {
	}

	public int getIdAlcaldia() {
		return this.idAlcaldia;
	}

	public void setIdAlcaldia(int idAlcaldia) {
		this.idAlcaldia = idAlcaldia;
	}

	public String getAlcalde() {
		return this.alcalde;
	}

	public void setAlcalde(String alcalde) {
		this.alcalde = alcalde;
	}

	public String getCorreo() {
		return this.correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public String getDireccion() {
		return this.direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getHorarioAtencion() {
		return this.horarioAtencion;
	}

	public void setHorarioAtencion(String horarioAtencion) {
		this.horarioAtencion = horarioAtencion;
	}

	public String getLogo() {
		return this.logo;
	}

	public void setLogo(String logo) {
		this.logo = logo;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getTelefono() {
		return this.telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public List<EnlaceIntere> getEnlaceInteres() {
		return this.enlaceInteres;
	}

	public void setEnlaceInteres(List<EnlaceIntere> enlaceInteres) {
		this.enlaceInteres = enlaceInteres;
	}

	public EnlaceIntere addEnlaceIntere(EnlaceIntere enlaceIntere) {
		getEnlaceInteres().add(enlaceIntere);
		enlaceIntere.setAlcaldia(this);

		return enlaceIntere;
	}

	public EnlaceIntere removeEnlaceIntere(EnlaceIntere enlaceIntere) {
		getEnlaceInteres().remove(enlaceIntere);
		enlaceIntere.setAlcaldia(null);

		return enlaceIntere;
	}

	public List<Noticia> getNoticias() {
		return this.noticias;
	}

	public void setNoticias(List<Noticia> noticias) {
		this.noticias = noticias;
	}

	public Noticia addNoticia(Noticia noticia) {
		getNoticias().add(noticia);
		noticia.setAlcaldia(this);

		return noticia;
	}

	public Noticia removeNoticia(Noticia noticia) {
		getNoticias().remove(noticia);
		noticia.setAlcaldia(null);

		return noticia;
	}

	public List<PreguntaFrecuente> getPreguntaFrecuentes() {
		return this.preguntaFrecuentes;
	}

	public void setPreguntaFrecuentes(List<PreguntaFrecuente> preguntaFrecuentes) {
		this.preguntaFrecuentes = preguntaFrecuentes;
	}

	public PreguntaFrecuente addPreguntaFrecuente(PreguntaFrecuente preguntaFrecuente) {
		getPreguntaFrecuentes().add(preguntaFrecuente);
		preguntaFrecuente.setAlcaldia(this);

		return preguntaFrecuente;
	}

	public PreguntaFrecuente removePreguntaFrecuente(PreguntaFrecuente preguntaFrecuente) {
		getPreguntaFrecuentes().remove(preguntaFrecuente);
		preguntaFrecuente.setAlcaldia(null);

		return preguntaFrecuente;
	}

	public List<Tramite> getTramites() {
		return this.tramites;
	}

	public void setTramites(List<Tramite> tramites) {
		this.tramites = tramites;
	}

	public Tramite addTramite(Tramite tramite) {
		getTramites().add(tramite);
		tramite.setAlcaldia(this);

		return tramite;
	}

	public Tramite removeTramite(Tramite tramite) {
		getTramites().remove(tramite);
		tramite.setAlcaldia(null);

		return tramite;
	}

	public List<Usuario> getUsuarios() {
		return this.usuarios;
	}

	public void setUsuarios(List<Usuario> usuarios) {
		this.usuarios = usuarios;
	}

	public Usuario addUsuario(Usuario usuario) {
		getUsuarios().add(usuario);
		usuario.setAlcaldia(this);

		return usuario;
	}

	public Usuario removeUsuario(Usuario usuario) {
		getUsuarios().remove(usuario);
		usuario.setAlcaldia(null);

		return usuario;
	}

}