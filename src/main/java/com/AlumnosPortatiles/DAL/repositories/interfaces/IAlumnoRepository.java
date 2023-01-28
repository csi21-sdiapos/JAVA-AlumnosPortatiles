package com.AlumnosPortatiles.DAL.repositories.interfaces;

import java.util.List;

import com.AlumnosPortatiles.DAL.entities.Alumno;


public interface IAlumnoRepository {

	
	/**
	 * List alumnos.
	 *
	 * @return the list
	 * @throws Exception the exception
	 */
	public List<Alumno> listAlumnos() throws Exception;
	
	
	
	/**
	 * Find by id alumno.
	 *
	 * @param alumno_id the alumno id
	 * @return the alumno
	 * @throws Exception the exception
	 */
	public Alumno findByIdAlumno(long alumno_id) throws Exception;
	
	
	
	/**
	 * Insert alumno.
	 *
	 * @param alumno the alumno
	 * @throws Exception the exception
	 */
	public void insertAlumno(Alumno alumno) throws Exception;
	
	
	
	/**
	 * Edits the alumno.
	 *
	 * @param alumno_id the alumno id
	 * @param alumno_nombre the alumno nombre
	 * @param alumno_apellidos the alumno apellidos
	 * @param alumno_telefono the alumno telefono
	 * No recibe ningún portatil porque el enunciado dice que el portatil siempre será el mismo para el alumno
	 * @throws Exception the exception
	 */
	public void editAlumno(long alumno_id, String alumno_nombre, String alumno_apellidos, String alumno_telefono) throws Exception;
	
	
	
	/**
	 * Delete by id alumno.
	 *
	 * @param alumno_id the alumno id
	 * @throws Exception the exception
	 */
	public void deleteByIdAlumno(long alumno_id) throws Exception;
	
	
	
	/**
	 * Delete alumno.
	 *
	 * @param alumno the alumno
	 * @throws Exception the exception
	 */
	public void deleteAlumno(Alumno alumno) throws Exception;
	
}