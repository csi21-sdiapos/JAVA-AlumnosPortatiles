package com.AlumnosPortatiles.DAL.repositories.implementations;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.PersistenceUnit;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.AlumnosPortatiles.DAL.entities.Alumno;
import com.AlumnosPortatiles.DAL.repositories.interfaces.IAlumnoRepository;


@Repository(value = "AlumnoRepositoryImpl")
public class AlumnoRepositoryImpl implements IAlumnoRepository {

	
	/** The entity manager factory. */
	@PersistenceUnit(name = "AlumnosPortatiles", unitName = "AlumnosPortatiles")
    private EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("AlumnosPortatiles");

	
	
	/**
	 * List alumnos - WITH QUERY.
	 *
	 * @return the list
	 * @throws Exception the exception
	 */
	@Override
	public List<Alumno> listAlumnos() throws Exception {
		// The EntityManager class allows operations such as create, read, update, delete
		EntityManager entityManager = entityManagerFactory.createEntityManager();
						
		// the lowercase a refers to the object
		// :objectID is a parameterized query thats value is set below
		String query = "SELECT a FROM Alumno a WHERE a.id IS NOT NULL";
		    	
		// Issue the query and get a matching object
		TypedQuery<Alumno> typedQuery = entityManager.createQuery(query, Alumno.class);
		List<Alumno> listaAlumnos = new ArrayList<>();
		    	
		try {
			// Get matching objects and output
		    listaAlumnos = typedQuery.getResultList();
		}
		    	
		catch(NoResultException ex) {
			ex.printStackTrace();
		}
		    	
		finally {
			// Close EntityManager
		    // entityManager.flush();
			// entityManager.clear();
		    entityManager.close();
		}
		    	
		return listaAlumnos;
	}
	
	
	
	/**
	 * Find by id alumno - WITH QUERY.
	 *
	 * @param alumno_id the alumno id
	 * @return the alumno
	 * @throws Exception the exception
	 */
	@Override
	public Alumno findByIdAlumno(long alumno_id) throws Exception {
		// The EntityManager class allows operations such as create, read, update, delete
		EntityManager entityManager = entityManagerFactory.createEntityManager();
						
		// the lowercase a refers to the object
		// :objectID is a parameterized query thats value is set below
		String query = "SELECT a FROM Alumno a WHERE a.id = :alumnoID";
		    	
		// Issue the query and get a matching object
		TypedQuery<Alumno> typedQuery = entityManager.createQuery(query, Alumno.class);
		typedQuery.setParameter("alumnoID", alumno_id);

		Alumno alumno = new Alumno();
		    	
		try {
			// Get matching the object and output
		    alumno = typedQuery.getSingleResult();	
		}
		    	
		catch(NoResultException e) {
			e.printStackTrace();
		}
		    	
		finally {
			// Close EntityManager
			// entityManager.flush();
		    // entityManager.clear();
		    entityManager.close();
		}
		    	
		return alumno;
	}
	
	

	/**
	 * Insert alumno - NO QUERY.
	 *
	 * @param alumno the alumno
	 * @throws Exception the exception
	 */
	@Override
	public void insertAlumno(Alumno alumno) throws Exception {
		// The EntityManager class allows operations such as create, read, update, delete
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		// Used to issue transactions on the EntityManager
		EntityTransaction entityTransaction = null;
				 
		try {
			// Get transaction and start
		    entityTransaction = entityManager.getTransaction();
		    entityTransaction.begin();
		 
		    // Save the object
		    entityManager.merge(alumno);
		    entityTransaction.commit();
		            
		} catch (Exception ex) {
			// If there is an exception rollback changes
		    if (entityTransaction != null) {
		    	entityTransaction.rollback();
		    }
		            
		    ex.printStackTrace();
		        
		} finally {
			// Close EntityManager
		    // entityManager.flush();
		    // entityManager.clear();
		    entityManager.close();
		}
	}
	
	
	
	/**
	 * Edits the alumno - WITH QUERY.
	 *
	 * @param alumno_id the alumno id
	 * @param alumno_nombre the alumno nombre
	 * @param alumno_apellidos the alumno apellidos
	 * @param alumno_telefono the alumno telefono
	 * No recibe ningún portatil porque el enunciado dice que el portatil siempre será el mismo para el alumno
	 * @throws Exception the exception
	 */
	@Override
	public void editAlumno(long alumno_id, String alumno_nombre, String alumno_apellidos, String alumno_telefono) throws Exception {
		// The EntityManager class allows operations such as create, read, update, delete
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		// Used to issue transactions on the EntityManager
		EntityTransaction entityTransaction = null;
						
		// the lowercase a refers to the object
		// :objectID is a parameterized query thats value is set below
		String jpql = "UPDATE Alumno a SET a.alumno_nombre = :alumnoNOMBRE, a.alumno_apellidos = :alumnoAPELLIDOS, a.alumno_telefono = :alumnoTELEFONO WHERE a.id = :alumnoID";
		
		// Issue the query and get a matching object
		Query query = entityManager.createQuery(jpql);
		query.setParameter("alumnoID", alumno_id);
		query.setParameter("alumnoNOMBRE", alumno_nombre);
		query.setParameter("alumnoAPELLIDOS", alumno_apellidos);
		query.setParameter("alumnoTELEFONO", alumno_telefono);
    	
    	int nRegistrosEditados = 0;
    	
    	try {
    		// Get transaction and start
		    entityTransaction = entityManager.getTransaction();
		    entityTransaction.begin();
		    
    		// Get matching the object and output
    		nRegistrosEditados = query.executeUpdate();
    		entityTransaction.commit();
    		System.out.println("\n\n[INFO] -Numero de alumnos editados: " + nRegistrosEditados);
		
    	} catch (Exception ex) {
    		// If there is an exception rollback changes
		    if (entityTransaction != null) {
		    	entityTransaction.rollback();
		    }
		    
			ex.printStackTrace();
		
    	} finally {
    		// Close EntityManager
    		// entityManager.flush();
    		// entityManager.clear();
    		entityManager.close();
		}
	}
	
	

	/**
	 * Edits the alumno - NO QUERY.
	 *
	 * @param alumno_id the alumno id
	 * @throws Exception the exception
	 */
/*
	@Override
	public void editAlumno(long alumno_id, String alumno_nombre, String alumno_apellidos, String alumno_telefono) throws Exception {
		// The EntityManager class allows operations such as create, read, update, delete
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		// Used to issue transactions on the EntityManager
		EntityTransaction entityTransaction = null;
				
		Alumno alumno = new Alumno();
				
		try {
			// Get transaction and start
		    entityTransaction = entityManager.getTransaction();
		    entityTransaction.begin();
		 
		    // Find object and make changes
		    alumno = entityManager.find(Alumno.class, alumno_id);
		    alumno.setAlumno_nombre(alumno_nombre);
		    alumno.setAlumno_apellidos(alumno_apellidos);
		    alumno.setAlumno_telefono(alumno_telefono);
		 
		    // Save the object
		    entityManager.merge(alumno);
		    entityTransaction.commit();
		            
		} catch (Exception ex) {
			// If there is an exception rollback changes
		    if (entityTransaction != null) {
		    	entityTransaction.rollback();
		    }
		            
		    ex.printStackTrace();
		        
		} finally {
			// Close EntityManager
			// entityManager.flush();
		    // entityManager.clear();
		    entityManager.close();
		}
	}
*/
	
	
	
	/**
	 * Delete by id alumno - WITH QUERY.
	 *
	 * @param alumno_id the alumno id
	 * @throws Exception the exception
	 */
	@Override
	public void deleteByIdAlumno(long alumno_id) throws Exception {
		// The EntityManager class allows operations such as create, read, update, delete
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		// Used to issue transactions on the EntityManager
		EntityTransaction entityTransaction = null;
				
		// the lowercase a refers to the object
    	// :objectID is a parameterized query thats value is set below
		String jpql = "DELETE FROM Alumno a WHERE a.id = :alumnoID";
    	
		// Issue the query and get a matching object
		Query query = entityManager.createQuery(jpql);
    	query.setParameter("alumnoID", alumno_id);
    	
    	int nRegistrosEliminados = 0;
    	
    	try {
    		// Get transaction and start
		    entityTransaction = entityManager.getTransaction();
		    entityTransaction.begin();
		    
    		// Get matching the object and output
    		nRegistrosEliminados = query.executeUpdate();
    		entityTransaction.commit();
    		System.out.println("\n\n[INFO] -Numero de alumnos eliminados: " + nRegistrosEliminados);
		
    	} catch (Exception ex) {
    		// If there is an exception rollback changes
		    if (entityTransaction != null) {
		    	entityTransaction.rollback();
		    }
		    
			ex.printStackTrace();
		
    	} finally {
    		// Close EntityManager
    		// entityManager.flush();
    		// entityManager.clear();
    		entityManager.close();
		}
	}
	
	

	/**
	 * Delete by id alumno - NO QUERY.
	 *
	 * @param alumno the alumno
	 * @throws Exception the exception
	 */
/*
	@Override
	public void deleteByIdAlumno(long alumno_id) throws Exception {
		// The EntityManager class allows operations such as create, read, update, delete
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		// Used to issue transactions on the EntityManager
		EntityTransaction entityTransaction = null;
						
		Alumno alumno = new Alumno();
		 
		try {
			entityTransaction = entityManager.getTransaction();
		    entityTransaction.begin();
		            
		    alumno = entityManager.find(Alumno.class, alumno_id);
		    entityManager.remove(entityManager.contains(alumno) ? alumno : entityManager.merge(alumno));
		    
		    entityTransaction.commit();
		        
		} catch (Exception ex) {
			// If there is an exception rollback changes
		    if (entityTransaction != null) {
		    	entityTransaction.rollback();
		    }
		            
		    ex.printStackTrace();
		        
		} finally {
			// Close EntityManager
		    // entityManager.flush();
		    // entityManager.clear();
		    entityManager.close();
		}
	}
*/
	

	/**
	 * Delete alumno - NO QUERY.
	 *
	 * @param alumno the alumno
	 * @throws Exception the exception
	 */
	@Override
	public void deleteAlumno(Alumno alumno) throws Exception {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		// Used to issue transactions on the EntityManager
		EntityTransaction entityTransaction = null;
		 
		try {
			entityTransaction = entityManager.getTransaction();
		    entityTransaction.begin();
		    
		    entityManager.remove(entityManager.contains(alumno) ? alumno : entityManager.merge(alumno));		    
		    
		    entityTransaction.commit();
		    
		} catch (Exception ex) {
		    // If there is an exception rollback changes
			if (entityTransaction != null) {
				entityTransaction.rollback();
		    }
		            
		    ex.printStackTrace();
		        
		} finally {
			// Close EntityManager
		    // entityManager.flush();
		    // entityManager.clear();
		    entityManager.close();
		}
	}
	
}
