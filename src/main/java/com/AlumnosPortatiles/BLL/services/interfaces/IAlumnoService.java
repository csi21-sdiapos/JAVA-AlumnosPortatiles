package com.AlumnosPortatiles.BLL.services.interfaces;

import com.AlumnosPortatiles.DAL.entities.Alumno;


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
	 * Editar nombre apellidos telefono de un alumno.
	 *
	 * @throws Exception the exception
	 */
	public void editarNombreApellidosTelefonoDeUnAlumno() throws Exception;
	
	
	
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