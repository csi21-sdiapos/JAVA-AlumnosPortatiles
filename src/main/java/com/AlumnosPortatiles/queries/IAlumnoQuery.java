package com.AlumnosPortatiles.queries;

import java.util.List;

import com.AlumnosPortatiles.entities.Alumno;
import com.AlumnosPortatiles.entities.Portatil;


public interface IAlumnoQuery {

	
	/**
	 * Listar alumnos.
	 *
	 * @return the list
	 * @throws Exception the exception
	 */
	public List<Alumno> listarAlumnos() throws Exception;
	
	
	
	/**
	 * Buscar alumno por id.
	 *
	 * @param alumno_id the alumno id
	 * @return the alumno
	 * @throws Exception the exception
	 */
	public Alumno buscarAlumnoPorId(long alumno_id) throws Exception;
	
	
	
	/**
	 * Insertar alumno.
	 *
	 * @param alumno the alumno
	 * @return true, if successful
	 * @throws Exception the exception
	 */
	public boolean insertarAlumno(Alumno alumno) throws Exception;
	
	
	
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
	public boolean editarAlumno(long alumno_id, String alumno_nombre, String alumno_apellidos, String alumno_telefono) throws Exception;
	
	
	
	/**
	 * Eliminar alumno por id.
	 *
	 * @param alumno_id the alumno id
	 * @return true, if successful
	 * @throws Exception the exception
	 */
	public boolean eliminarAlumnoPorId(long alumno_id) throws Exception;
	
	
	
	/**
	 * Eliminar alumno.
	 *
	 * @param alumno the alumno
	 * @return true, if successful
	 * @throws Exception the exception
	 */
	public boolean eliminarAlumno(Alumno alumno) throws Exception;
	
}