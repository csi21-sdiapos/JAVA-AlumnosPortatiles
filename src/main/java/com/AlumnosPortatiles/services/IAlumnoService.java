package com.AlumnosPortatiles.services;

import com.AlumnosPortatiles.entities.Alumno;


public interface IAlumnoService {

	
	/**
	 * Mostrar lista de alumnos.
	 *
	 * @throws Exception the exception
	 */
	public void mostrarListaDeAlumnos() throws Exception;
	
	
	
	/**
	 * Mostrar un alumno.
	 *
	 * @throws Exception the exception
	 */
	public void mostrarUnAlumno() throws Exception;
	
	
	
	/**
	 * Seleccionar un alumno.
	 *
	 * @return the alumno
	 * @throws Exception the exception
	 */
	public Alumno seleccionarUnAlumno() throws Exception;
	
	
	
	/**
	 * Crear un nuevo alumno.
	 *
	 * @throws Exception the exception
	 */
	public void crearUnNuevoAlumno() throws Exception;
	
	
	
	/**
	 * Editar nombre apellidos telefono portatil de un alumno.
	 *
	 * @throws Exception the exception
	 */
	public void editarNombreApellidosTelefonoPortatilDeUnAlumno() throws Exception;
	
	
	
	/**
	 * Eliminar un alumno por id.
	 *
	 * @throws Exception the exception
	 */
	public void eliminarUnAlumnoPorId() throws Exception;
	
	
	
	/**
	 * Eliminar un alumno.
	 *
	 * @throws Exception the exception
	 */
	public void eliminarUnAlumno() throws Exception;
	
}