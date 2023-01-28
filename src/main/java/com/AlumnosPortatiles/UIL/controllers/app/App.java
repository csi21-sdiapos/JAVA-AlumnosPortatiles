package com.AlumnosPortatiles.UIL.controllers.app;

import java.util.Scanner;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.springframework.stereotype.Controller;

import com.AlumnosPortatiles.BLL.services.implementations.AlumnoServiceImpl;
import com.AlumnosPortatiles.BLL.services.implementations.PortatilServiceImpl;
import com.AlumnosPortatiles.BLL.services.interfaces.IAlumnoService;
import com.AlumnosPortatiles.BLL.services.interfaces.IPortatilService;
import com.AlumnosPortatiles.tools.Tools;

@Controller("App")
public class App {
	
	// Create an EntityManagerFactory when you start the application
    private static EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("AlumnosPortatiles");
    private static Scanner scanner = new Scanner(System.in);
    
	public static void main(String[] args) throws Exception {

		IPortatilService portatilService = new PortatilServiceImpl();
		IAlumnoService alumnoService = new AlumnoServiceImpl();
				
		int opcion = 0;
				
		do {
			opcion = Tools.showMenuAndSelectOption();
					
			switch (opcion) {
				case 0:
					System.out.println("\n\n\tHa elegido la opción 0 de salir.");
					break;
						
				case 1:
					alumnoService.crearUnNuevoAlumno();
					break;
							
				case 2:
					alumnoService.eliminarUnAlumnoPorId();
					break;
							
				case 3:
					portatilService.crearUnNuevoPortatil();
					break;
							
				case 4:
					break;
							
				case 5:
					break;
							
				case 6:
					alumnoService.mostrarListaDeAlumnos();
					break;
			}
					
		} while (opcion != 0);
		
		Tools.pararPrograma();
		
		scanner.close();
		entityManagerFactory.close();
	}

}
