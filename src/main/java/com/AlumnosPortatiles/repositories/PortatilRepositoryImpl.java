package com.AlumnosPortatiles.repositories;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.PersistenceUnit;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.AlumnosPortatiles.entities.Portatil;


@Repository("PortatilRepositoryImpl")
public class PortatilRepositoryImpl implements IPortatilRepository {

	
	/** The entity manager factory. */
	@PersistenceUnit(name = "AlumnosPortatiles")
    private EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("GestionGasolinera");

	
	
	/**
	 * List portatiles - WITH QUERY.
	 *
	 * @return the list
	 * @throws Exception the exception
	 */
	@Override
	public List<Portatil> listPortatiles() throws Exception {
		// The EntityManager class allows operations such as create, read, update, delete
		EntityManager entityManager = entityManagerFactory.createEntityManager();
								
		// the lowercase p refers to the object
		// :objectID is a parameterized query thats value is set below
		String query = "SELECT p FROM Portatil p WHERE p.id IS NOT NULL";
				    	
		// Issue the query and get a matching object
		TypedQuery<Portatil> typedQuery = entityManager.createQuery(query, Portatil.class);
		List<Portatil> listaPortatiles = new ArrayList<>();
				    	
		try {
			// Get matching objects and output
			listaPortatiles = typedQuery.getResultList();
		}
				    	
		catch(NoResultException ex) {
			ex.printStackTrace();
		}
				    	
		finally {
			// Close EntityManager
			entityManager.flush();
			entityManager.clear();
			entityManager.close();
		}
				    	
		return listaPortatiles;
	}
	
	

	/**
	 * Find by id portatil - WITH QUERY.
	 *
	 * @param portatil_id the portatil id
	 * @return the portatil
	 * @throws Exception the exception
	 */
	@Override
	public Portatil findByIdPortatil(long portatil_id) throws Exception {
		// The EntityManager class allows operations such as create, read, update, delete
		EntityManager entityManager = entityManagerFactory.createEntityManager();
								
		// the lowercase p refers to the object
		// :objectID is a parameterized query thats value is set below
		String query = "SELECT p FROM Portatil p WHERE p.id = :portatilID";
				    	
		// Issue the query and get a matching object
		TypedQuery<Portatil> typedQuery = entityManager.createQuery(query, Portatil.class);
		typedQuery.setParameter("portatilID", portatil_id);

		Portatil portatil = new Portatil();
				    	
		try {
			// Get matching the object and output
			portatil = typedQuery.getSingleResult();	
		}
				    	
		catch(NoResultException e) {
			e.printStackTrace();
		}
				    	
		finally {
			// Close EntityManager
			entityManager.flush();
			entityManager.clear();
			entityManager.close();
		}
				    	
		return portatil;
	}
	
	

	/**
	 * Insert portatil - NO QUERY.
	 *
	 * @param portatil the portatil
	 * @throws Exception the exception
	 */
	@Override
	public void insertPortatil(Portatil portatil) throws Exception {
		// The EntityManager class allows operations such as create, read, update, delete
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		// Used to issue transactions on the EntityManager
		EntityTransaction entityTransaction = null;
						 
		try {
			// Get transaction and start
			entityTransaction = entityManager.getTransaction();
			entityTransaction.begin();
				 
			// Save the object
			entityManager.merge(portatil);
			entityTransaction.commit();
				            
		} catch (Exception ex) {
			// If there is an exception rollback changes
			if (entityTransaction != null) {
			entityTransaction.rollback();
			}
				            
			ex.printStackTrace();
				        
		} finally {
			// Close EntityManager
			entityManager.flush();
			entityManager.clear();
			entityManager.close();
		}
	}
	
	
	
	/**
	 * Edits the portatil - WITH QUERY.
	 *
	 * @param portatil_id the portatil id
	 * @param portatil_marca the portatil marca
	 * @param portatil_modelo the portatil modelo
	 * @throws Exception the exception
	 */
	@Override
	public void editPortatil(long portatil_id, String portatil_marca, String portatil_modelo) throws Exception {
		// The EntityManager class allows operations such as create, read, update, delete
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		// the lowercase a refers to the object
    	// :objectID is a parameterized query thats value is set below
		String query = "UPDATE Portatil p SET p.portatil_marca = :portatilMARCA, p.portatil_modelo = :portatilMODELO WHERE p.id = :portatilID";
    	
		// Issue the query and get a matching object
    	TypedQuery<Portatil> typedQuery = entityManager.createQuery(query, Portatil.class);
    	typedQuery.setParameter("portatilID", portatil_id);
    	typedQuery.setParameter("portatilMARCA", portatil_marca);
    	typedQuery.setParameter("portatilMODELO", portatil_modelo);
    	
    	int nRegistrosEditados = 0;
    	
    	try {
    		// Get matching the object and output
    		nRegistrosEditados = typedQuery.executeUpdate();
    		System.out.println("\n\n[INFO] -Numero de portatiles editados: " + nRegistrosEditados);
		
    	} catch (Exception ex) {
			ex.printStackTrace();
		
    	} finally {
    		// Close EntityManager
    		entityManager.flush();
    		entityManager.clear();
    		entityManager.close();
		}
	}
	
	

	/**
	 * Edits the portatil - NO QUERY.
	 *
	 * @param portatil_id the portatil id
	 * @param portatil_marca the portatil marca
	 * @param portatil_modelo the portatil modelo
	 * @throws Exception the exception
	 */
/*
	@Override
	public void editPortatil(long portatil_id, String portatil_marca, String portatil_modelo) throws Exception {
		// The EntityManager class allows operations such as create, read, update, delete
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		// Used to issue transactions on the EntityManager
		EntityTransaction entityTransaction = null;
						
		Portatil portatil = new Portatil();
						
		try {
			// Get transaction and start
			entityTransaction = entityManager.getTransaction();
			entityTransaction.begin();
				 
			// Find object and make changes
			portatil = entityManager.find(Portatil.class, portatil_id);
			portatil.setPortatil_marca(portatil_marca);
			portatil.setPortatil_modelo(portatil_modelo);
			
			// Save the object
			entityManager.merge(portatil);
			entityTransaction.commit();
				            
		} catch (Exception ex) {
			// If there is an exception rollback changes
			if (entityTransaction != null) {
				entityTransaction.rollback();
			}
				            
			ex.printStackTrace();
				        
		} finally {
			// Close EntityManager
			entityManager.flush();
			entityManager.clear();
			entityManager.close();
		}
	}
*/
	
	
	
	/**
	 * Delete by id portatil - WITH QUERY.
	 *
	 * @param portatil_id the portatil id
	 * @throws Exception the exception
	 */
	@Override
	public void deleteByIdPortatil(long portatil_id) throws Exception {
		// The EntityManager class allows operations such as create, read, update, delete
		EntityManager entityManager = entityManagerFactory.createEntityManager();
				
		// the lowercase p refers to the object
		// :objectID is a parameterized query thats value is set below
		String query = "DELETE FROM Portatil p WHERE p.id = :portatilID";
		    	
		// Issue the query and get a matching object
		TypedQuery<Portatil> typedQuery = entityManager.createQuery(query, Portatil.class);
		typedQuery.setParameter("portatilID", portatil_id);
		    	
		int nRegistrosEliminados = 0;
		    	
		try {
			// Get matching the object and output
		    nRegistrosEliminados = typedQuery.executeUpdate();
		    System.out.println("\n\n[INFO] -Numero de portatiles eliminados: " + nRegistrosEliminados);
				
		} catch (Exception ex) {
			ex.printStackTrace();
				
		} finally {
			// Close EntityManager
		    entityManager.flush();
		    entityManager.clear();
		    entityManager.close();
		}
	}
	

	/**
	 * Delete by id portatil - NO QUERY.
	 *
	 * @param portatil_id the portatil id
	 * @throws Exception the exception
	 */
/*
	@Override
	public void deleteByIdPortatil(long portatil_id) throws Exception {
		// The EntityManager class allows operations such as create, read, update, delete
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		// Used to issue transactions on the EntityManager
		EntityTransaction entityTransaction = null;
								
		Portatil portatil = new Portatil();
				 
		try {
			entityTransaction = entityManager.getTransaction();
			entityTransaction.begin();
				            
			portatil = entityManager.find(Portatil.class, portatil_id);
			entityManager.remove(entityManager.contains(portatil) ? portatil : entityManager.merge(portatil));
				    
			entityTransaction.commit();
				        
		} catch (Exception ex) {
			// If there is an exception rollback changes
			if (entityTransaction != null) {
				entityTransaction.rollback();
			}
				            
			ex.printStackTrace();
				        
		} finally {
			// Close EntityManager
			entityManager.flush();
			entityManager.clear();
			entityManager.close();
		}
	}
*/
	
	
	
	/**
	 * Delete portatil - NO QUERY.
	 *
	 * @param portatil the portatil
	 * @throws Exception the exception
	 */
	@Override
	public void deletePortatil(Portatil portatil) throws Exception {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		// Used to issue transactions on the EntityManager
		EntityTransaction entityTransaction = null;
		 
		try {
			entityTransaction = entityManager.getTransaction();
		    entityTransaction.begin();
		    
			entityManager.remove(entityManager.contains(portatil) ? portatil : entityManager.merge(portatil));
		    
		    entityTransaction.commit();
		    
		} catch (Exception ex) {
		    // If there is an exception rollback changes
			if (entityTransaction != null) {
				entityTransaction.rollback();
		    }
		            
		    ex.printStackTrace();
		        
		} finally {
			// Close EntityManager
		    entityManager.flush();
		    entityManager.clear();
		    entityManager.close();
		}
	}
	
}