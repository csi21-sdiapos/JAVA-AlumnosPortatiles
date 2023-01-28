package com.AlumnosPortatiles.BLL.queries.implementations;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.AlumnosPortatiles.BLL.queries.interfaces.IAlumnoQuery;
import com.AlumnosPortatiles.DAL.entities.Alumno;
import com.AlumnosPortatiles.DAL.repositories.implementations.AlumnoRepositoryImpl;
import com.AlumnosPortatiles.DAL.repositories.interfaces.IAlumnoRepository;


@Service("AlumnoQueryImpl")
public class AlumnoQueryImpl implements IAlumnoQuery {

	
	/** The alumno repository impl. */
	@Autowired
	IAlumnoRepository alumnoRepositoryImpl = new AlumnoRepositoryImpl();

	
	
	/**
	 * Listar alumnos.
	 *
	 * @return the list
	 * @throws Exception the exception
	 */
	@Transactional
	@Override
	public List<Alumno> listarAlumnos() throws Exception {
		try {
			return alumnoRepositoryImpl.listAlumnos();
		} catch (Exception e) {
			System.out.println("[ERROR] - Error al listar los alumnos (return null): " + e);
			return null;
		}
	}
	
	

	/**
	 * Buscar alumno por id.
	 *
	 * @param alumno_id the alumno id
	 * @return the alumno
	 * @throws Exception the exception
	 */
	@Transactional
	@Override
	public Alumno buscarAlumnoPorId(long alumno_id) throws Exception {
		try {
			return alumnoRepositoryImpl.findByIdAlumno(alumno_id);
		} catch (Exception e) {
			System.out.println("[ERROR] - Error al buscar el alumno (return null): " + e);
			return null;
		}
	}

	
	
	/**
	 * Insertar alumno.
	 *
	 * @param alumno the alumno
	 * @return true, if successful
	 * @throws Exception the exception
	 */
	@Transactional
	@Override
	public boolean insertarAlumno(Alumno alumno) throws Exception {
		try {
			alumnoRepositoryImpl.insertAlumno(alumno);
			return true;
		} catch (Exception e) {
			System.out.println("[ERROR] - Error al insertar el nuevo alumno: " + e);
			return false;
		}
	}
	
	

	/**
	 * Editar alumno.
	 *
	 * @param alumno_id the alumno id
	 * @param alumno_nombre the alumno nombre
	 * @param alumno_apellidos the alumno apellidos
	 * @param alumno_telefono the alumno telefono
	 * No recibe ningún portatil porque el enunciado dice que el portatil siempre será el mismo para el alumno
	 * @return true, if successful
	 * @throws Exception the exception
	 */
	@Transactional
	@Override
	public boolean editarAlumno(long alumno_id, String alumno_nombre, String alumno_apellidos, String alumno_telefono) throws Exception {
		try {
			alumnoRepositoryImpl.editAlumno(alumno_id, alumno_nombre, alumno_apellidos, alumno_telefono);
			return true;
		} catch (Exception e) {
			System.out.println("[ERROR] - Error al editar el alumno seleccionado: " + e);
			return false;
		}
	}

	
	
	/**
	 * Eliminar alumno por id.
	 *
	 * @param alumno_id the alumno id
	 * @return true, if successful
	 * @throws Exception the exception
	 */
	@Override
	public boolean eliminarAlumnoPorId(long alumno_id) throws Exception {
		try {
			alumnoRepositoryImpl.deleteByIdAlumno(alumno_id);
			return true;
		} catch (Exception e) {
			System.out.println("[ERROR] - Error al eliminar el alumno seleccionado: " + e);
			return false;
		}
	}
	
	

	/**
	 * Eliminar alumno.
	 *
	 * @param alumno the alumno
	 * @return true, if successful
	 * @throws Exception the exception
	 */
	@Transactional
	@Override
	public boolean eliminarAlumno(Alumno alumno) throws Exception {
		try {
			alumnoRepositoryImpl.deleteAlumno(alumno);
			return true;
		} catch (Exception e) {
			System.out.println("[ERROR] - Error al eliminar el alumno seleccionado: " + e);
			return false;
		}
	}
	
}