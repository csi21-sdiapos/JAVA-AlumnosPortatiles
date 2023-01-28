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

import com.AlumnosPortatiles.tools.Tools;


@Entity
@Table(name = "dwh_ap_portatil", schema = "dwh_alumnos_portatiles")
public class Portatil implements Serializable {

	private static final long serialVersionUID = 1L;

	
	/******************************************* ATRIBUTOS *********************************************/
	@Column(name = "portatil_uuid", unique = false, nullable = false)		// defino el alumno_uuid como unique=false por el supuesto teórico de que en un futuro se pudieran crear ciertas clases, que implementen métodos, que insertasen al final de la jornada laboral todos los objetos guardados en persistencia durante el día, y así reducir las llamadas a la bbdd, y de esta forma todos esos objetos llevarían el mismo uuid en la inserción
	private UUID portatil_uuid;
	
	@Id
	@Column(name = "portatil_id", unique = true, nullable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long portatil_id;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "portatil_date", unique = false, nullable = false)		// defino el alumno_date como unique=false por el supuesto teórico de que en un futuro se pudieran crear ciertas clases, que implementen métodos, que insertasen al final de la jornada laboral todos los objetos guardados en persistencia durante el día, y así reducir las llamadas a la bbdd, y de esta forma todos esos objetos llevarían la misma fecha de inserción
	private Calendar portatil_date;
	
	@Column(name = "portatil_marca", unique = false, nullable = false)
	private String portatil_marca;
	
	@Column(name = "portatil_modelo", unique = false, nullable = false)
	private String portatil_modelo;
	
	/******************************************* RELACIONES *********************************************/
	@OneToOne(optional = true, cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
	@JoinColumn(name = "alumno_id")
	private Alumno alumno;
	
	
	/******************************************* CONSTRUCTORES *********************************************/
	// constructor lleno
	public Portatil(String portatil_marca, String portatil_modelo) {
		super();
		this.portatil_uuid = Tools.generarUUID();
		this.portatil_date = Calendar.getInstance();
		this.portatil_marca = portatil_marca;
		this.portatil_modelo = portatil_modelo;
		this.alumno = new Alumno();
	}

	// constructor vacío
	public Portatil() {
		super();
	}
	
	
	/******************************************* GETTER Y SETTERS *********************************************/
	public UUID getPortatil_uuid() {
		return portatil_uuid;
	}

	public void setPortatil_uuid(UUID portatil_uuid) {
		this.portatil_uuid = portatil_uuid;
	}

	public long getPortatil_id() {
		return portatil_id;
	}

	public void setPortatil_id(long portatil_id) {
		this.portatil_id = portatil_id;
	}

	public Calendar getPortatil_date() {
		return portatil_date;
	}

	public void setPortatil_date(Calendar portatil_date) {
		this.portatil_date = portatil_date;
	}

	public String getPortatil_marca() {
		return portatil_marca;
	}

	public void setPortatil_marca(String portatil_marca) {
		this.portatil_marca = portatil_marca;
	}

	public String getPortatil_modelo() {
		return portatil_modelo;
	}

	public void setPortatil_modelo(String portatil_modelo) {
		this.portatil_modelo = portatil_modelo;
	}

	public Alumno getAlumno() {
		return alumno;
	}

	public void setAlumno(Alumno alumno) {
		this.alumno = alumno;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
	/******************************************* MÉTODOS *********************************************/

	
	/******************************************* HashCode y Equals *********************************************/
	@Override
	public int hashCode() {
		return Objects.hash(alumno, portatil_date, portatil_id, portatil_marca, portatil_modelo, portatil_uuid);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Portatil other = (Portatil) obj;
		return Objects.equals(alumno, other.alumno) && Objects.equals(portatil_date, other.portatil_date)
				&& portatil_id == other.portatil_id && Objects.equals(portatil_marca, other.portatil_marca)
				&& Objects.equals(portatil_modelo, other.portatil_modelo)
				&& Objects.equals(portatil_uuid, other.portatil_uuid);
	}
	
	
	/******************************************* ToString *********************************************/
	@Override
	public String toString() {
		return "\nPortatil [" + 
					"portatil_uuid=" + portatil_uuid + 
					", portatil_id=" + portatil_id + 
					", portatil_date=" + portatil_date + 
					", portatil_marca=" + portatil_marca + 
					", portatil_modelo=" + portatil_modelo + 
					", alumno=" + alumno + 
				"]";
	}
	
}