package com.AlumnosPortatiles.BLL.dtos.interfaces;

import com.AlumnosPortatiles.BLL.dtos.models.AlumnoDTO;
import com.AlumnosPortatiles.BLL.dtos.models.PortatilDTO;
import com.AlumnosPortatiles.DAL.entities.Alumno;
import com.AlumnosPortatiles.DAL.entities.Portatil;


public interface IToDAO {

	
	/**
	 * Alumno DT oto alumno DAO.
	 *
	 * @param alumnoDTO the alumno DTO
	 * @return the alumno
	 */
	public Alumno alumnoDTOtoAlumnoDAO(AlumnoDTO alumnoDTO);
	
	
	
	/**
	 * Portatil DT oto portatil DAO.
	 *
	 * @param portatilDTO the portatil DTO
	 * @return the portatil
	 */
	public Portatil portatilDTOtoPortatilDAO(PortatilDTO portatilDTO);
	
}