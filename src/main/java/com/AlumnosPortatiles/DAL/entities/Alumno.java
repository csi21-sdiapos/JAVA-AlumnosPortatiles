package com.AlumnosPortatiles.DAL.entities;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Objects;
import java.util.UUID;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.AlumnosPortatiles.UIL.tools.Tools;


@Entity
@Table(name = "dwh_ap_alumno", schema = "dwh_alumnos_portatiles")
public class Alumno implements Serializable {

	private static final long serialVersionUID = 1L;

	
	/******************************************* ATRIBUTOS *********************************************/
	@Column(name = "alumno_uuid", unique = false, nullable = false)		// defino el alumno_uuid como unique=false por el supuesto teórico de que en un futuro se pudieran crear ciertas clases, que implementen métodos, que insertasen al final de la jornada laboral todos los objetos guardados en persistencia durante el día, y así reducir las llamadas a la bbdd, y de esta forma todos esos objetos llevarían el mismo uuid en la inserción
	private UUID alumno_uuid;
	
	@Id
	@Column(name = "alumno_id", unique = true, nullable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long alumno_id;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "alumno_date", unique = false, nullable = false)		// defino el alumno_date como unique=false por el supuesto teórico de que en un futuro se pudieran crear ciertas clases, que implementen métodos, que insertasen al final de la jornada laboral todos los objetos guardados en persistencia durante el día, y así reducir las llamadas a la bbdd, y de esta forma todos esos objetos llevarían la misma fecha de inserción
	private Calendar alumno_date;
	
	@Column(name = "alumno_nombre", unique = false, nullable = false)
	private String alumno_nombre;
	
	@Column(name = "alumno_apellidos", unique = false, nullable = false)
	private String alumno_apellidos;
	
	@Column(name = "alumno_telefono", unique = true, nullable = false)	// defino el alumno_telefono como unique=true porque se presupone que un alumno no le va a hacer una copia a su tarjeta SIM y se la vaya a dar a un compañero
	private String alumno_telefono;
	
	/******************************************* RELACIONES *********************************************/
	@OneToOne(optional = true, cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
	@JoinColumn(name = "portatil_id")
	private Portatil portatil;

	
	/******************************************* CONSTRUCTORES *********************************************/
	// constructor lleno
	public Alumno(String alumno_nombre, String alumno_apellidos, String alumno_telefono, Portatil portatil) {
		super();
		this.alumno_uuid = Tools.generarUUID();
		this.alumno_date = Calendar.getInstance();
		this.alumno_nombre = alumno_nombre;
		this.alumno_apellidos = alumno_apellidos;
		this.alumno_telefono = alumno_telefono;
		this.portatil = portatil;
	}

	// constructor vacío
	public Alumno() {
		super();
	}
	
	
	/******************************************* GETTER Y SETTERS *********************************************/
	public UUID getAlumno_uuid() {
		return alumno_uuid;
	}

	public void setAlumno_uuid(UUID alumno_uuid) {
		this.alumno_uuid = alumno_uuid;
	}

	public long getAlumno_id() {
		return alumno_id;
	}

	public void setAlumno_id(long alumno_id) {
		this.alumno_id = alumno_id;
	}

	public Calendar getAlumno_date() {
		return alumno_date;
	}

	public void setAlumno_date(Calendar alumno_date) {
		this.alumno_date = alumno_date;
	}

	public String getAlumno_nombre() {
		return alumno_nombre;
	}

	public void setAlumno_nombre(String alumno_nombre) {
		this.alumno_nombre = alumno_nombre;
	}

	public String getAlumno_apellidos() {
		return alumno_apellidos;
	}

	public void setAlumno_apellidos(String alumno_apellidos) {
		this.alumno_apellidos = alumno_apellidos;
	}

	public String getAlumno_telefono() {
		return alumno_telefono;
	}

	public void setAlumno_telefono(String alumno_telefono) {
		this.alumno_telefono = alumno_telefono;
	}

	public Portatil getPortatil() {
		return portatil;
	}

	public void setPortatil(Portatil portatil) {
		this.portatil = portatil;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	
	/******************************************* MÉTODOS *********************************************/
	
	
	/******************************************* HashCode y Equals *********************************************/
	@Override
	public int hashCode() {
		return Objects.hash(alumno_apellidos, alumno_date, alumno_id, alumno_nombre, alumno_telefono, alumno_uuid,
				portatil);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Alumno other = (Alumno) obj;
		return Objects.equals(alumno_apellidos, other.alumno_apellidos)
				&& Objects.equals(alumno_date, other.alumno_date) && alumno_id == other.alumno_id
				&& Objects.equals(alumno_nombre, other.alumno_nombre)
				&& Objects.equals(alumno_telefono, other.alumno_telefono)
				&& Objects.equals(alumno_uuid, other.alumno_uuid) && Objects.equals(portatil, other.portatil);
	}
	
	
	/******************************************* ToString *********************************************/
	@Override
	public String toString() {
		return "\nAlumno [" + 
					"alumno_uuid=" + alumno_uuid + 
					", alumno_id=" + alumno_id + 
					", alumno_date=" + alumno_date.getTime() + 
					", alumno_nombre=" + alumno_nombre + 
					", alumno_apellidos=" + alumno_apellidos + 
					", alumno_telefono=" + alumno_telefono + 
					", portatil=" + portatil + 
				"]";
	}
	
}