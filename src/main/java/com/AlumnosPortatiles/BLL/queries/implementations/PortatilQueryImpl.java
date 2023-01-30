package com.AlumnosPortatiles.BLL.queries.implementations;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.AlumnosPortatiles.BLL.queries.interfaces.IPortatilQuery;
import com.AlumnosPortatiles.DAL.entities.Portatil;
import com.AlumnosPortatiles.DAL.repositories.implementations.PortatilRepositoryImpl;
import com.AlumnosPortatiles.DAL.repositories.interfaces.IPortatilRepository;


@Service("PortatilQueryImpl")
public class PortatilQueryImpl implements IPortatilQuery {

	
	/** The portatil repository impl. */
	@Autowired
	IPortatilRepository portatilRepositoryImpl = new PortatilRepositoryImpl();

	
	
	/**
	 * Listar portatiles.
	 *
	 * @return the list
	 * @throws Exception the exception
	 */
	@Transactional
	@Override
	public List<Portatil> listarPortatiles() throws Exception {
		try {
			return portatilRepositoryImpl.listPortatiles();
		} catch (Exception e) {
			System.out.println("[ERROR] - Error al listar los portatiles (return null): " + e);
			return null;
		}
	}
	
	
	
	/**
	 * Buscar portatil por id.
	 *
	 * @param portatil_id the portatil id
	 * @return the portatil
	 * @throws Exception the exception
	 */
	@Transactional
	@Override
	public Portatil buscarPortatilPorId(long portatil_id) throws Exception {
		try {
			return portatilRepositoryImpl.findByIdPortatil(portatil_id);
		} catch (Exception e) {
			System.out.println("[ERROR] - Error al buscar el portatil (return null): " + e);
			return null;
		}
	}

	
	
	/**
	 * Insertar portatil.
	 *
	 * @param portatil the portatil
	 * @return true, if successful
	 * @throws Exception the exception
	 */
	@Transactional
	@Override
	public boolean insertarPortatil(Portatil portatil) throws Exception {
		try {
			portatilRepositoryImpl.insertPortatil(portatil);
			return true;
		} catch (Exception e) {
			System.out.println("[ERROR] - Error al insertar el nuevo portatil: " + e);
			return false;
		}
	}

	
	
	/**
	 * Editar portatil.
	 *
	 * @param portatil_id the portatil id
	 * @param portatil_marca the portatil marca
	 * @param portatil_modelo the portatil modelo
	 * @return true, if successful
	 * @throws Exception the exception
	 */
	@Transactional
	@Override
	public boolean editarPortatil(long portatil_id, String portatil_marca, String portatil_modelo) throws Exception {
		try {
			portatilRepositoryImpl.editPortatil(portatil_id, portatil_marca, portatil_modelo);
			return true;
		} catch (Exception e) {
			System.out.println("[ERROR] - Error al editar el portatil seleccionado: " + e);
			return false;
		}
	}

	
	
	/**
	 * Eliminar portatil por id.
	 *
	 * @param portatil_id the portatil id
	 * @return true, if successful
	 * @throws Exception the exception
	 */
	@Transactional
	@Override
	public boolean eliminarPortatilPorId(long portatil_id) throws Exception {
		try {
			portatilRepositoryImpl.deleteByIdPortatil(portatil_id);
			return true;
		} catch (Exception e) {
			System.out.println("[ERROR] - Error al eliminar el portatil seleccionado: " + e);
			return false;
		}
	}

	
	
	/**
	 * Eliminar portatil.
	 *
	 * @param portatil the portatil
	 * @return true, if successful
	 * @throws Exception the exception
	 */
	@Transactional
	@Override
	public boolean eliminarPortatil(Portatil portatil) throws Exception {
		try {
			portatilRepositoryImpl.deletePortatil(portatil);
			return true;
		} catch (Exception e) {
			System.out.println("[ERROR] - Error al eliminar el portatil seleccionado: " + e);
			return false;
		}
	}
	
}