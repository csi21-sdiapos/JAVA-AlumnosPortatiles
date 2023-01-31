package com.AlumnosPortatiles.DAL.entities;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Objects;
import java.util.UUID;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.AlumnosPortatiles.UIL.tools.Tools;

/*
 * One-to-One Relationship in JPA --> https://www.baeldung.com/jpa-one-to-one
 * 
 * @JoinColumn Annotation Explained --> https://www.baeldung.com/jpa-join-column
 * 
 * What is referencedColumnName used for in JPA? --> https://stackoverflow.com/questions/11244569/what-is-referencedcolumnname-used-for-in-jpa
 * 
 * Hibernate @PrimaryKeyJoinColumn Annotation --> https://www.javaguides.net/2019/12/hibernate-primarykeyjoincolumn.html
 *  
 * targetEntity example --> http://www.java2s.com/Code/Java/JPA/OneToManyTargetEntity.htm
 */

@Entity(name = "Alumno")
@Table(name = "dwh_ap_alumno", schema = "dwh_alumnos_portatiles")
public class Alumno implements Serializable {

	private static final long serialVersionUID = 1L;

	
	/******************************************* ATRIBUTOS *********************************************/
	@Column(table = "dwh_ap_alumno", name = "alumno_uuid", insertable = true, updatable = true, unique = false, nullable = false)		// defino el alumno_uuid como unique=false por el supuesto teórico de que en un futuro se pudieran crear ciertas clases, que implementen métodos, que insertasen al final de la jornada laboral todos los objetos guardados en persistencia durante el día, y así reducir las llamadas a la bbdd, y de esta forma todos esos objetos llevarían el mismo uuid en la inserción
	private UUID alumno_uuid;
	
	@Id
	@Column(table = "dwh_ap_alumno", name = "alumno_id", insertable = false, updatable = false, unique = true, nullable = false)		// defino el alumno_id como insertable y updatable false ya que este campo se autogenera en el momento de la creación del objeto y no debería de insertarse ni actualizarse mediante sentencias sql
	@GeneratedValue(strategy = GenerationType.IDENTITY, generator = "dwh_ap_alumno_alumno_id_seq")
	private long alumno_id;
	
	@Temporal(value = TemporalType.TIMESTAMP)
	@Column(table = "dwh_ap_alumno", name = "alumno_date", insertable = true, updatable = true, unique = false, nullable = false)		// defino el alumno_date como unique=false por el supuesto teórico de que en un futuro se pudieran crear ciertas clases, que implementen métodos, que insertasen al final de la jornada laboral todos los objetos guardados en persistencia durante el día, y así reducir las llamadas a la bbdd, y de esta forma todos esos objetos llevarían la misma fecha de inserción
	private Calendar alumno_date;
	
	@Column(table = "dwh_ap_alumno", name = "alumno_nombre", insertable = true, updatable = true, unique = false, nullable = false)
	private String alumno_nombre;
	
	@Column(table = "dwh_ap_alumno", name = "alumno_apellidos", insertable = true, updatable = true, unique = false, nullable = false)
	private String alumno_apellidos;
	
	@Column(table = "dwh_ap_alumno", name = "alumno_telefono", insertable = true, updatable = true, unique = true, nullable = false)	// defino el alumno_telefono como unique=true porque se presupone que un alumno no le va a hacer una copia a su tarjeta SIM y se la vaya a dar a un compañero
	private String alumno_telefono;
	
	/******************************************* RELACIONES *********************************************/
	@OneToOne(cascade = CascadeType.MERGE, fetch = FetchType.EAGER, orphanRemoval = false, optional = true)
	@JoinColumn(table = "dwh_ap_alumno", name = "portatil_id", referencedColumnName = "portatil_id", foreignKey = @ForeignKey(name = "fk_portatil_id"), insertable = true, updatable = true, unique = false, nullable = true)
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