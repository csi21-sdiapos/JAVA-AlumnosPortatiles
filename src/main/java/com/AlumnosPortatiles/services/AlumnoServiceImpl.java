package com.AlumnosPortatiles.services;

import java.util.List;
import java.util.Scanner;

import org.springframework.stereotype.Service;

import com.AlumnosPortatiles.entities.Alumno;
import com.AlumnosPortatiles.entities.Portatil;
import com.AlumnosPortatiles.queries.AlumnoQueryImpl;
import com.AlumnosPortatiles.queries.IAlumnoQuery;
import com.AlumnosPortatiles.tools.Tools;


@Service("AlumnoServiceImpl")
public class AlumnoServiceImpl implements IAlumnoService {

	
	public static Scanner scanner = new Scanner(System.in);
	
	IAlumnoQuery alumnoQueryImpl = new AlumnoQueryImpl();

	// IToDTO toDtoServiceImpl = new ToDtoServiceImpl();
	
	// IToDAO toDaoServiceImpl = new ToDaoServiceImpl();
	
	
	
	@Override
	public void mostrarListaDeAlumnos() throws Exception {
		List<Alumno> listaAlumnos = alumnoQueryImpl.listarAlumnos();
		
		for (Alumno alumno : listaAlumnos) {
			System.out.println(alumno.toString());
		}
	}
	
	

	@Override
	public void mostrarUnAlumno() throws Exception {
		System.out.println("\n\nLista de alumnos matriculados");
		System.out.println("------------------------------");
		mostrarListaDeAlumnos();
		
		int alumno_id = Tools.capturaEntero_v3("\n\nIntroduzca un número para mostrar un alumno", 0, 99);
		Alumno alumno = alumnoQueryImpl.buscarAlumnoPorId(alumno_id);
		System.out.println(alumno.toString());
	}
	
	

	@Override
	public Alumno seleccionarUnAlumno() throws Exception {
		System.out.println("\n\nLista de alumnos matriculados");
		System.out.println("------------------------------");
		mostrarListaDeAlumnos();
		
		int alumno_id = Tools.capturaEntero_v3("\n\nIntroduzca un número para mostrar un alumno", 0, 99);
		Alumno alumno = alumnoQueryImpl.buscarAlumnoPorId(alumno_id);
		
		return alumno;
	}

	
	
	@Override
	public void crearUnNuevoAlumno() throws Exception {
		System.out.print("\n\nIntroduzca el nombre del nuevo alumno:\t");
		String alumno_nombre = scanner.next();
		
		System.out.print("\n\nIntroduzca los apellidos del nuevo alumno:\t");
		String alumno_apellidos = scanner.nextLine();
		
		System.out.print("\n\nIntroduzca el teléfono del nuevo alumno:\t");
		String alumno_telefono = scanner.next();
		
		System.out.print("\n\nSeleccione el portatil a asignar al nuevo alumno");
		// Portatil portatil = portatilServiceImpl.seleccionarUnPortatil();
		Portatil portatil = new Portatil();
		
		alumnoQueryImpl.insertarAlumno(new Alumno(alumno_nombre, alumno_apellidos, alumno_telefono, portatil));
		System.out.println("\n\nEl nuevo alumno " + alumno_nombre + " se ha matriculado correctamente");
	}
	
	

	@Override
	public void editarNombreApellidosTelefonoPortatilDeUnAlumno() throws Exception {
		System.out.print("\n\nVamos a editar los datos de un alumno");
		Alumno alumno = seleccionarUnAlumno();
		
		System.out.print("\n\nIntroduzca un nuevo nombre para el alumno seleccionado:\t");
		String alumno_nombre = scanner.next();
		
		System.out.print("\n\nIntroduzca los nuevos apellidos para el alumno seleccionado:\t");
		String alumno_apellidos = scanner.nextLine();
		
		System.out.print("\n\nIntroduzca un nuevo teléfono para el alumno seleccionado:\t");
		String alumno_telefono = scanner.next();
		
		alumnoQueryImpl.editarAlumno(alumno.getAlumno_id(), alumno_nombre, alumno_apellidos, alumno_telefono);
		System.out.println("\n\nEl alumno selecccionado se ha modificado correctamente");
	}
	
	

	@Override
	public void eliminarUnAlumnoPorId() throws Exception {
		System.out.print("\n\nVamos a eliminar un alumno por su ID");
		System.out.println("\n\nLista de alumnos matriculados");
		System.out.println("------------------------------");
		mostrarListaDeAlumnos();
		
		int alumno_id = Tools.capturaEntero_v3("\n\nIntroduzca un número para eliminar ese alumno", 0, 99);
		
		if (Tools.preguntaSiNo("¿Está seguro de que desea eliminar el alumno seleccionado?")) {
			alumnoQueryImpl.eliminarAlumnoPorId(alumno_id);
			System.out.println("\n\nEl alumno seleccionado se ha eliminado correctamente");
		}
		else {
			System.out.println("\n\nEl alumno seleccionado NO se ha eliminado");
		}
	}
	
	

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