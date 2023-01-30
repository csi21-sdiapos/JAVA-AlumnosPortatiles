package com.AlumnosPortatiles.BLL.dtos.models;

import java.util.Calendar;
import java.util.Objects;
import java.util.UUID;

import org.springframework.stereotype.Component;

import com.AlumnosPortatiles.DAL.entities.Alumno;

@Component("PortatilDTO")
public class PortatilDTO {

	
	/******************************************* ATRIBUTOS *********************************************/
	private UUID portatil_uuid;
	private long portatil_id;
	private Calendar portatil_date;
	private String portatil_marca;
	private String portatil_modelo;
	
	/******************************************* RELACIONES *********************************************/
	private Alumno alumno;
	
	
	/******************************************* CONSTRUCTORES *********************************************/
	// constructor vacío
	public PortatilDTO(String portatil_marca, String portatil_modelo) {
		super();
		this.portatil_marca = portatil_marca;
		this.portatil_modelo = portatil_modelo;
		// this.alumno = null;
	}

	// constructor vacío
	public PortatilDTO() {
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
		PortatilDTO other = (PortatilDTO) obj;
		return Objects.equals(alumno, other.alumno) && Objects.equals(portatil_date, other.portatil_date)
				&& portatil_id == other.portatil_id && Objects.equals(portatil_marca, other.portatil_marca)
				&& Objects.equals(portatil_modelo, other.portatil_modelo)
				&& Objects.equals(portatil_uuid, other.portatil_uuid);
	}
	
	
	/******************************************* ToString *********************************************/
	@Override
	public String toString() {
		return "PortatilDTO [" + 
					"portatil_uuid=" + portatil_uuid + 
					", portatil_id=" + portatil_id + 
					", portatil_date=" + portatil_date + 
					", portatil_marca=" + portatil_marca + 
					", portatil_modelo=" + portatil_modelo + 
					", alumno=" + alumno + 
				"]";
	}
	
}