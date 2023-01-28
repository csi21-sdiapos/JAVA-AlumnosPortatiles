package com.AlumnosPortatiles.BLL.dtos.interfaces;

import com.AlumnosPortatiles.BLL.dtos.models.AlumnoDTO;
import com.AlumnosPortatiles.BLL.dtos.models.PortatilDTO;
import com.AlumnosPortatiles.DAL.entities.Portatil;


public interface IToDTO {

	
	/**
	 * To alumno DTO.
	 *
	 * @param alumno_nombre the alumno nombre
	 * @param alumno_apellidos the alumno apellidos
	 * @param alumno_telefono the alumno telefono
	 * @param portatil the portatil
	 * @return the alumno DTO
	 */
	public AlumnoDTO toAlumnoDTO(String alumno_nombre, String alumno_apellidos, String alumno_telefono, Portatil portatil);
	
	
	
	/**
	 * To portatil DTO.
	 *
	 * @param portatil_marca the portatil marca
	 * @param portatil_modelo the portatil modelo
	 * @return the portatil DTO
	 */
	public PortatilDTO toPortatilDTO(String portatil_marca, String portatil_modelo);
	
}