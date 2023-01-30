package com.AlumnosPortatiles.BLL.services.implementations;

import java.util.List;
import java.util.Scanner;

import org.springframework.stereotype.Service;

import com.AlumnosPortatiles.BLL.queries.implementations.AlumnoQueryImpl;
import com.AlumnosPortatiles.BLL.queries.implementations.PortatilQueryImpl;
import com.AlumnosPortatiles.BLL.queries.interfaces.IAlumnoQuery;
import com.AlumnosPortatiles.BLL.queries.interfaces.IPortatilQuery;
import com.AlumnosPortatiles.BLL.services.interfaces.IAlumnoService;
import com.AlumnosPortatiles.BLL.services.interfaces.IPortatilService;
import com.AlumnosPortatiles.DAL.entities.Alumno;
import com.AlumnosPortatiles.DAL.entities.Portatil;
import com.AlumnosPortatiles.UIL.tools.Tools;


@Service("AlumnoServiceImpl")
public class AlumnoServiceImpl implements IAlumnoService {

	
	/** The scanner. */
	public static Scanner scanner = new Scanner(System.in);
	
	/** The alumno query impl. */
	IAlumnoQuery alumnoQueryImpl = new AlumnoQueryImpl();
	
	/** The portatil query impl. */
	IPortatilQuery portatilQueryImpl = new PortatilQueryImpl();
	
	/** The portatil service impl. */
	IPortatilService portatilServiceImpl = new PortatilServiceImpl();

	// IToDTO toDtoServiceImpl = new ToDtoServiceImpl();
	
	// IToDAO toDaoServiceImpl = new ToDaoServiceImpl();
	
	
	
	/**
	 * Mostrar lista de alumnos.
	 *
	 * @throws Exception the exception
	 */
	@Override
	public void mostrarListaDeAlumnos() throws Exception {
		List<Alumno> listaAlumnos = alumnoQueryImpl.listarAlumnos();
		
		for (Alumno alumno : listaAlumnos) {
			System.out.println(alumno.toString());
		}
	}
	
	

	/**
	 * Mostrar un alumno.
	 *
	 * @throws Exception the exception
	 */
	@Override
	public void mostrarUnAlumno() throws Exception {
		System.out.println("\n\nLista de alumnos matriculados");
		System.out.println("------------------------------");
		mostrarListaDeAlumnos();
		
		int alumno_id = Tools.capturaEntero_v3("Introduzca un número para mostrar un alumno", 0, 99);
		Alumno alumno = alumnoQueryImpl.buscarAlumnoPorId(alumno_id);
		System.out.println(alumno.toString());
	}
	
	
	
	/**
	 * Mostrar el portatil de un alumno.
	 *
	 * @throws Exception the exception
	 */
	@Override
	public void mostrarElPortatilDeUnAlumno() throws Exception {
		System.out.println("\n\nLista de alumnos matriculados");
		System.out.println("------------------------------");
		mostrarListaDeAlumnos();
		
		int alumno_id = Tools.capturaEntero_v3("Introduzca un número de alumno para mostrar su portatil asignado", 0, 99);
		Alumno alumno = alumnoQueryImpl.buscarAlumnoPorId(alumno_id);
		System.out.println("\n\n" + alumno.getAlumno_id() + " - " + alumno.getAlumno_apellidos() + ", " + alumno.getAlumno_nombre() + " --> " + alumno.getPortatil().getPortatil_id() + " - " + alumno.getPortatil().getPortatil_marca() + " - " + alumno.getPortatil().getPortatil_modelo());
	}
	
	

	/**
	 * Seleccionar un alumno.
	 *
	 * @return the alumno
	 * @throws Exception the exception
	 */
	@Override
	public Alumno seleccionarUnAlumno() throws Exception {
		System.out.println("\n\nLista de alumnos matriculados");
		System.out.println("------------------------------");
		mostrarListaDeAlumnos();
		
		int alumno_id = Tools.capturaEntero_v3("Introduzca un número para mostrar un alumno", 0, 99);
		Alumno alumno = alumnoQueryImpl.buscarAlumnoPorId(alumno_id);
		
		return alumno;
	}
	
	
	
	/**
	 * Crear un nuevo alumno.
	 *
	 * @throws Exception the exception
	 */
	@Override
	public void crearUnNuevoAlumno() throws Exception {
		List<Portatil> listaPortatiles = portatilQueryImpl.listarPortatiles();
		
		if (listaPortatiles.size() > 0) {
			System.out.print("\n\nIntroduzca el nombre del nuevo alumno:\t");
			String alumno_nombre = scanner.next();
			
			System.out.print("\n\nIntroduzca los apellidos del nuevo alumno:\t");
			String alumno_apellidos = scanner.next();
			
			System.out.print("\n\nIntroduzca el teléfono del nuevo alumno:\t");
			String alumno_telefono = scanner.next();
			
			System.out.print("\n\nSeleccione el portatil a asignar al nuevo alumno");
			Portatil portatil = portatilServiceImpl.seleccionarUnPortatil();
			
			alumnoQueryImpl.insertarAlumno(new Alumno(alumno_nombre, alumno_apellidos, alumno_telefono, portatil));
			System.out.println("\n\nEl nuevo alumno " + alumno_nombre + " se ha matriculado correctamente");
		}
		else {
			System.out.println("\n\nLo sentimos, pero aún no hay portatiles para matricular nuevos alumnos");
			System.out.println("\nRegistre un portatil en primer lugar");
		}
	}
	
	

	/**
	 * Editar nombre apellidos telefono de un alumno.
	 *
	 * @throws Exception the exception
	 */
	@Override
	public void editarNombreApellidosTelefonoDeUnAlumno() throws Exception {
		System.out.print("\n\nVamos a editar los datos de un alumno");
		Alumno alumno = seleccionarUnAlumno();
		
		System.out.print("\n\nIntroduzca un nuevo nombre para el alumno seleccionado:\t");
		String alumno_nombre = scanner.next();
		
		System.out.print("\n\nIntroduzca los nuevos apellidos para el alumno seleccionado:\t");
		String alumno_apellidos = scanner.next();
		
		System.out.print("\n\nIntroduzca un nuevo teléfono para el alumno seleccionado:\t");
		String alumno_telefono = scanner.next();
		
		alumnoQueryImpl.editarAlumno(alumno.getAlumno_id(), alumno_nombre, alumno_apellidos, alumno_telefono);
		System.out.println("\n\nEl alumno selecccionado se ha modificado correctamente");
	}
	
	
	
	/**
	 * Eliminar un alumno por id.
	 *
	 * @throws Exception the exception
	 */
	@Override
	public void eliminarUnAlumnoPorId() throws Exception {
		System.out.print("\n\nVamos a eliminar un alumno por su ID");
		System.out.println("\n\nLista de alumnos matriculados");
		System.out.println("------------------------------");
		mostrarListaDeAlumnos();
		
		int alumno_id = Tools.capturaEntero_v3("Introduzca un número para eliminar ese alumno", 0, 99);
		Alumno alumno = alumnoQueryImpl.buscarAlumnoPorId(alumno_id);
		
		if (Tools.confirmacionPorNombre("Para eliminar el alumno seleccionado, escriba su nombre", alumno.getAlumno_nombre())) {
			alumnoQueryImpl.eliminarAlumnoPorId(alumno_id);
			System.out.println("\n\nEl alumno seleccionado se ha eliminado correctamente");
		}
		else {
			System.out.println("\n\nEl alumno seleccionado NO se ha eliminado");
		}
	}
	
	

	/**
	 * Eliminar un alumno.
	 *
	 * @throws Exception the exception
	 */
	@Override
	public void eliminarUnAlumno() throws Exception {
		System.out.print("\n\nVamos a eliminar un alumno");
		Alumno alumno = seleccionarUnAlumno();
		
		if (Tools.preguntaSiNo("¿Está seguro de que desea eliminar el alumno seleccionado?")) {
			alumnoQueryImpl.eliminarAlumno(alumno);
			System.out.println("\n\nEl alumno seleccionado se ha eliminado correctamente");
		}
		else {
			System.out.println("\n\nEl alumno seleccionado NO se ha eliminado");
		}
	}

}