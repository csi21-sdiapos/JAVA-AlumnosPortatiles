package com.AlumnosPortatiles.BLL.dtos.implementations;

import org.springframework.stereotype.Service;

import com.AlumnosPortatiles.BLL.dtos.interfaces.IToDAO;
import com.AlumnosPortatiles.BLL.dtos.models.AlumnoDTO;
import com.AlumnosPortatiles.BLL.dtos.models.PortatilDTO;
import com.AlumnosPortatiles.DAL.entities.Alumno;
import com.AlumnosPortatiles.DAL.entities.Portatil;


@Service("ToDAOserviceImpl")
public class ToDAOserviceImpl implements IToDAO {

	
	/**
	 * Alumno DT oto alumno DAO.
	 *
	 * @param alumnoDTO the alumno DTO
	 * @return the alumno
	 */
	@Override
	public Alumno alumnoDTOtoAlumnoDAO(AlumnoDTO alumnoDTO) {
		Alumno alumno = new Alumno();
		
		if (alumnoDTO != null) {
			alumno.setAlumno_nombre(alumnoDTO.getAlumno_nombre());
			alumno.setAlumno_apellidos(alumnoDTO.getAlumno_apellidos());
			alumno.setAlumno_telefono(alumnoDTO.getAlumno_telefono());
			alumno.setPortatil(alumnoDTO.getPortatil());
		}
		
		return alumno;
	}

	
	
	/**
	 * Portatil DT oto portatil DAO.
	 *
	 * @param portatilDTO the portatil DTO
	 * @return the portatil
	 */
	@Override
	public Portatil portatilDTOtoPortatilDAO(PortatilDTO portatilDTO) {
		Portatil portatil = new Portatil();
		
		if (portatilDTO != null) {
			portatil.setPortatil_marca(portatilDTO.getPortatil_marca());
			portatil.setPortatil_modelo(portatilDTO.getPortatil_modelo());
			portatil.setAlumno(portatilDTO.getAlumno());
		}
		
		return portatil;
	}

}