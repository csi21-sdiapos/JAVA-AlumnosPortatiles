package com.AlumnosPortatiles.repositories;

import java.util.List;

import com.AlumnosPortatiles.entities.Portatil;


public interface IPortatilRepository {

	
	/**
	 * List portatiles.
	 *
	 * @return the list
	 * @throws Exception the exception
	 */
	public List<Portatil> listPortatiles() throws Exception;
	
	
	
	/**
	 * Find by id portatil.
	 *
	 * @param portatil_id the portatil id
	 * @return the portatil
	 * @throws Exception the exception
	 */
	public Portatil findByIdPortatil(long portatil_id) throws Exception;
	
	
	
	/**
	 * Insert portatil.
	 *
	 * @param portatil the portatil
	 * @throws Exception the exception
	 */
	public void insertPortatil(Portatil portatil) throws Exception;
	
	
	
	/**
	 * Edits the portatil.
	 *
	 * @param portatil_id the portatil id
	 * @param portatil_marca the portatil marca
	 * @param portatil_modelo the portatil modelo
	 * @throws Exception the exception
	 */
	public void editPortatil(long portatil_id, String portatil_marca, String portatil_modelo) throws Exception;
	
	
	
	/**
	 * Delete by id portatil.
	 *
	 * @param portatil_id the portatil id
	 * @throws Exception the exception
	 */
	public void deleteByIdPortatil(long portatil_id) throws Exception;
	
	
	
	/**
	 * Delete portatil.
	 *
	 * @param portatil the portatil
	 * @throws Exception the exception
	 */
	public void deletePortatil(Portatil portatil) throws Exception;
	
}