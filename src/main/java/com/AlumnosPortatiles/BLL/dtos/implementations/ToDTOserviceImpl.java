package com.AlumnosPortatiles.BLL.dtos.implementations;

import org.springframework.stereotype.Service;

import com.AlumnosPortatiles.BLL.dtos.interfaces.IToDTO;
import com.AlumnosPortatiles.BLL.dtos.models.AlumnoDTO;
import com.AlumnosPortatiles.BLL.dtos.models.PortatilDTO;
import com.AlumnosPortatiles.DAL.entities.Portatil;


@Service("ToDTOserviceImpl")
public class ToDTOserviceImpl implements IToDTO {

	
	/**
	 * To alumno DTO.
	 *
	 * @param alumno_nombre the alumno nombre
	 * @param alumno_apellidos the alumno apellidos
	 * @param alumno_telefono the alumno telefono
	 * @param portatil the portatil
	 * @return the alumno DTO
	 */
	@Override
	public AlumnoDTO toAlumnoDTO(String alumno_nombre, String alumno_apellidos, String alumno_telefono, Portatil portatil) {

		AlumnoDTO alumnoDTO = new AlumnoDTO(alumno_nombre, alumno_apellidos, alumno_telefono, portatil);
		return alumnoDTO;
	}

	
	
	/**
	 * To portatil DTO.
	 *
	 * @param portatil_marca the portatil marca
	 * @param portatil_modelo the portatil modelo
	 * @return the portatil DTO
	 */
	@Override
	public PortatilDTO toPortatilDTO(String portatil_marca, String portatil_modelo) {

		PortatilDTO portatilDTO = new PortatilDTO(portatil_marca, portatil_modelo);
		return portatilDTO;
	}
	
}