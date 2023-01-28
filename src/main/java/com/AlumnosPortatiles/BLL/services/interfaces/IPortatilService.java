package com.AlumnosPortatiles.BLL.services.interfaces;

import com.AlumnosPortatiles.DAL.entities.Portatil;


public interface IPortatilService {

	
	/**
	 * Mostrar lista de portatiles.
	 *
	 * @throws Exception the exception
	 */
	public void mostrarListaDePortatiles() throws Exception;
	
	
	
	/**
	 * Mostrar un portatil.
	 *
	 * @throws Exception the exception
	 */
	public void mostrarUnPortatil() throws Exception;
	
	
	
	/**
	 * Seleccionar un portatil.
	 *
	 * @return the portatil
	 * @throws Exception the exception
	 */
	public Portatil seleccionarUnPortatil() throws Exception;
	
	
	
	/**
	 * Crear un nuevo portatil.
	 *
	 * @throws Exception the exception
	 */
	public void crearUnNuevoPortatil() throws Exception;
	
	
	
	/**
	 * Editar marca model alumno de un portatil.
	 *
	 * @throws Exception the exception
	 */
	public void editarMarcaModeloDeUnPortatil() throws Exception;
	
	
	
	/**
	 * Eliminar un portatil por id.
	 *
	 * @throws Exception the exception
	 */
	public void eliminarUnPortatilPorId() throws Exception;
	
	
	
	/**
	 * Eliminar un portatil.
	 *
	 * @throws Exception the exception
	 */
	public void eliminarUnPortatil() throws Exception;
	
}