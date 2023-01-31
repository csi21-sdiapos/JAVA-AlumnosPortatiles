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

@Entity(name = "Portatil")
@Table( name = "dwh_ap_portatil", schema = "dwh_alumnos_portatiles")
public class Portatil implements Serializable {

	private static final long serialVersionUID = 1L;

	
	/******************************************* ATRIBUTOS *********************************************/
	@Column(table = "dwh_ap_portatil", name = "portatil_uuid", insertable = true, updatable = true, unique = false, nullable = false)		// defino el portatil_uuid como unique=false por el supuesto teórico de que en un futuro se pudieran crear ciertas clases, que implementen métodos, que insertasen al final de la jornada laboral todos los objetos guardados en persistencia durante el día, y así reducir las llamadas a la bbdd, y de esta forma todos esos objetos llevarían el mismo uuid en la inserción
	private UUID portatil_uuid;
	
	@Id
	@Column(table = "dwh_ap_portatil", name = "portatil_id", insertable = false, updatable = false, unique = true, nullable = false)		// defino el alumno_id como insertable y updatable false ya que este campo se autogenera en el momento de la creación del objeto y no debería de insertarse ni actualizarse mediante sentencias sql
	@GeneratedValue(strategy = GenerationType.IDENTITY, generator = "dwh_ap_portatil_portatil_id_seq")
	private long portatil_id;
	
	@Temporal(value = TemporalType.TIMESTAMP)
	@Column(table = "dwh_ap_portatil", name = "portatil_date", insertable = true, updatable = true, unique = false, nullable = false)		// defino el portatil_date como unique=false por el supuesto teórico de que en un futuro se pudieran crear ciertas clases, que implementen métodos, que insertasen al final de la jornada laboral todos los objetos guardados en persistencia durante el día, y así reducir las llamadas a la bbdd, y de esta forma todos esos objetos llevarían la misma fecha de inserción
	private Calendar portatil_date;
	
	@Column(table = "dwh_ap_portatil", name = "portatil_marca", insertable = true, updatable = true, unique = false, nullable = false)
	private String portatil_marca;
	
	@Column(table = "dwh_ap_portatil", name = "portatil_modelo", insertable = true, updatable = true, unique = false, nullable = false)
	private String portatil_modelo;
	
	/******************************************* RELACIONES *********************************************/
	@OneToOne(mappedBy = "portatil", targetEntity = Alumno.class, cascade = CascadeType.MERGE, fetch = FetchType.EAGER, orphanRemoval = false, optional = true)
	private Alumno alumno;
	
	
	/******************************************* CONSTRUCTORES *********************************************/
	// constructor lleno
	public Portatil(String portatil_marca, String portatil_modelo) {
		super();
		this.portatil_uuid = Tools.generarUUID();
		this.portatil_date = Calendar.getInstance();
		this.portatil_marca = portatil_marca;
		this.portatil_modelo = portatil_modelo;
		// this.alumno = null;
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
	public String toString() {	// con una simple comprobación de si el alumno es nulo o no, podríamos añadir al menú una opción 7 de listar todos los portatiles, y al final de cada uno ver el id del alumno asignado o ver una interrogación si aún no está asignado
		if (alumno != null) {
			return "\nPortatil [" + 
					"portatil_uuid=" + portatil_uuid + 
					", portatil_id=" + portatil_id + 
					", portatil_date=" + portatil_date.getTime() + 
					", portatil_marca=" + portatil_marca + 
					", portatil_modelo=" + portatil_modelo + 
					// ", alumno=" + alumno +	// no tiene sentido mostrar al alumno entero aquí, porque si un alumno también muestra ya de por sí un portatil, esto nos llevaría entonces a un bucle infinito de presentaciones
					", \nalumno_id=" + alumno.getAlumno_id() +
				"]";
		}
		else {
			return "\nPortatil [" + 
					"portatil_uuid=" + portatil_uuid + 
					", portatil_id=" + portatil_id + 
					", portatil_date=" + portatil_date.getTime() + 
					", portatil_marca=" + portatil_marca + 
					", portatil_modelo=" + portatil_modelo + 
					// ", alumno=" + alumno +	// no tiene sentido mostrar al alumno entero aquí, porque si un alumno también muestra ya de por sí un portatil, esto nos llevaría entonces a un bucle infinito de presentaciones
					", \nalumno_id=sin asignar" +
				"]";
		}
	}
	
}