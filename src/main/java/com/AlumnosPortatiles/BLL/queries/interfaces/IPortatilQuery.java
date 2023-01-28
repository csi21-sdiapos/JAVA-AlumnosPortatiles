package com.AlumnosPortatiles.BLL.queries.interfaces;

import java.util.List;

import com.AlumnosPortatiles.DAL.entities.Portatil;


public interface IPortatilQuery {

	
	/**
	 * Listar portatiles.
	 *
	 * @return the list
	 * @throws Exception the exception
	 */
	public List<Portatil> listarPortatiles() throws Exception;
	
	
	
	/**
	 * Buscar portatil por id.
	 *
	 * @param portatil_id the portatil id
	 * @return the portatil
	 * @throws Exception the exception
	 */
	public Portatil buscarPortatilPorId(long portatil_id) throws Exception;
	
	
	
	/**
	 * Insertar portatil.
	 *
	 * @param portatil the portatil
	 * @return true, if successful
	 * @throws Exception the exception
	 */
	public boolean insertarPortatil(Portatil portatil) throws Exception;
	
	
	
	/**
	 * Editar portatil.
	 *
	 * @param portatil_id the portatil id
	 * @param portatil_marca the portatil marca
	 * @param portatil_modelo the portatil modelo
	 * @return true, if successful
	 * @throws Exception the exception
	 */
	public boolean editarPortatil(long portatil_id, String portatil_marca, String portatil_modelo) throws Exception;
	
	
	
	/**
	 * Eliminar portatil por id.
	 *
	 * @param portatil_id the portatil id
	 * @return true, if successful
	 * @throws Exception the exception
	 */
	public boolean eliminarPortatilPorId(long portatil_id) throws Exception;
	
	
	
	/**
	 * Eliminar portatil.
	 *
	 * @param portatil the portatil
	 * @return true, if successful
	 * @throws Exception the exception
	 */
	public boolean eliminarPortatil(Portatil portatil) throws Exception;

}