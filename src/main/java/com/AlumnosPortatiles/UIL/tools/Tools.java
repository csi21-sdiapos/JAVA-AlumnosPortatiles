package com.AlumnosPortatiles.UIL.tools;

import java.util.Scanner;
import java.util.UUID;


public class Tools {
	
	/** The scanner. */
	public static Scanner scanner = new Scanner(System.in);
	
	
	
	/**
	 * Show menu.
	 */
	public static void showMenu() {
		System.out.println("\n\n\n\n\n\n\t\t\t╔════════════════════════════════════════════╗");
        System.out.println("\t\t\t║ Opciones del instituto                     ║");
        System.out.println("\t\t\t╠════════════════════════════════════════════╣");
        System.out.println("\t\t\t║ 1) Matricula de un alumno                  ║");
        System.out.println("\t\t\t║ 2) Baja de un alumno                       ║");
        System.out.println("\t\t\t║ 3) Alta de portatil                        ║");
        System.out.println("\t\t\t║ 4) Baja de portatil                        ║");
        System.out.println("\t\t\t║ 5) Consulta portatil asignado a un alumno  ║");
        System.out.println("\t\t\t║ 6) Consulta alumno asignado a un portatil  ║");
        System.out.println("\t\t\t║ 7) Ver todos los alumnos con su portatil   ║");
        System.out.println("\t\t\t║ 8) Ver todos los portatiles con su alumno  ║");
        System.out.println("\t\t\t║                                            ║");
        System.out.println("\t\t\t║ 0) Salir                                   ║");
        System.out.println("\t\t\t║                                            ║");
        System.out.println("\t\t\t╚════════════════════════════════════════════╝");
	}

	
	
	/**
	 * Show menu and select option.
	 *
	 * @return the int
	 */
	public static int showMenuAndSelectOption() {
		System.out.println("\n\n\n\n\n\n\t\t\t╔════════════════════════════════════════════╗");
        System.out.println("\t\t\t║ Opciones del instituto                     ║");
        System.out.println("\t\t\t╠════════════════════════════════════════════╣");
        System.out.println("\t\t\t║ 1) Matricula de un alumno                  ║");
        System.out.println("\t\t\t║ 2) Baja de un alumno                       ║");
        System.out.println("\t\t\t║ 3) Alta de portatil                        ║");
        System.out.println("\t\t\t║ 4) Baja de portatil                        ║");
        System.out.println("\t\t\t║ 5) Consulta portatil asignado a un alumno  ║");
        System.out.println("\t\t\t║ 6) Consulta alumno asignado a un portatil  ║");
        System.out.println("\t\t\t║ 7) Ver todos los alumnos con su portatil   ║");
        System.out.println("\t\t\t║ 8) Ver todos los portatiles con su alumno  ║");
        System.out.println("\t\t\t║                                            ║");
        System.out.println("\t\t\t║ 0) Salir                                   ║");
        System.out.println("\t\t\t║                                            ║");
        System.out.println("\t\t\t╚════════════════════════════════════════════╝");
        
        return capturaEntero_v3("Introduzca una opcion del menu", 0, 8);
    }
	
	
	
	/**
	 * Captura entero v 1.
	 *
	 * @param mensaje the mensaje
	 * @param min the min
	 * @param max the max
	 * @return the int
	 */
	public static int capturaEntero_v1(String mensaje, int min, int max) {
		int num = 0;
		boolean numOk = false;
		String input = null;
		
		do {
			System.out.print("\n\n" + mensaje + ":\t");
			input = scanner.next();
			numOk = tryParseInt(input, num);
			
			if (!numOk) {
				System.out.println("\n\n\\tError. El dato introducido no es un valor numérico.");
			}
			else if (num < min || num > max) {
				System.out.println("\n\n\tError. Esa opción no se encuentra en el menú.");
				numOk = false;
			}	
		} while(!numOk);
		
		return num;
	}
	
	
	
	/**
	 * Captura entero v 2.
	 *
	 * @param mensaje the mensaje
	 * @param min the min
	 * @param max the max
	 * @return the int
	 */
	public static int capturaEntero_v2(String mensaje, int min, int max) {
		int num = 0;
		boolean numOk = false;
		String input = null;
		
		do {
			System.out.print("\n\n" + mensaje + ":\t");
			input = scanner.next();
			numOk = isNumeric(input, num);
			
			if (!numOk) {
				System.out.println("\n\n\\tError. El dato introducido no es un valor numérico.");
			}
			else {
				num = Integer.parseInt(input);
				
				if (num < min || num > max) {
					System.out.println("\n\n\tError. El número introducido debe estar entre [" + min + "-" + max + "].");
					numOk = false;
				}
				else {
					numOk = true;
				}
			}
		} while(!numOk);
		
		return num;
	}
	
	
	
	/**
	 * Captura entero v 3.
	 *
	 * @param mensaje the mensaje
	 * @param min the min
	 * @param max the max
	 * @return the int
	 */
	public static int capturaEntero_v3(String mensaje, int min, int max) {
		int num = 0;
		boolean numOk = false;
		String input = null;
		
		do {
			System.out.print("\n\n" + mensaje + ":\t");
			numOk = false;
			input = scanner.next();
			
			if (input == null) {
				System.out.println("\n\n\tError. Por favor, debe introducir algún valor.");
				numOk = false;
			}
			try {
				num = Integer.parseInt(input);
				
				if (num < min || num > max) {
					System.out.println("\n\n\tError. El número introducido debe estar entre [" + min + "-" + max + "].");
					numOk = false;
				}
				else {
					numOk = true;
				}
			} catch (NumberFormatException e) {
				System.out.println("\n\n\tError. El dato introducido no es un valor numérico.");
				numOk = false;
			}
		} while(!numOk);
		
		return num;
	}
	
	
	
	/**
	 * Try parse int.
	 *
	 * @param input the input
	 * @param num the num
	 * @return true, if successful
	 */
	public static boolean tryParseInt(String input, int num) {
		boolean numOk = false;
		
		try {
			num = Integer.parseInt(input);
			numOk = true;
		} catch (NumberFormatException ex) {
		    numOk = false;
		}
		
		return numOk;
	}
	
	
	
	/**
	 * Checks if is numeric.
	 *
	 * @param input the input
	 * @return true, if is numeric
	 */
	public static boolean isNumeric(String input, int num) {
	    if (input == null) {
	        return false;
	    }
	    try {
	        num = Integer.parseInt(input);
	    } catch (NumberFormatException nfe) {
	        return false;
	    }
	    return true;
	}
	
	
	
	/**
	 * Generar UUID.
	 *
	 * @return the uuid
	 */
	public static UUID generarUUID() {	// https://www.baeldung.com/java-uuid
		UUID uuid = UUID.randomUUID();
	    return uuid;
	}
	
	
	
	/**
	 * Pregunta si no.
	 *
	 * @param pregunta the pregunta
	 * @return true, if successful
	 */
	public static boolean preguntaSiNo(String pregunta) {	// ¿por qué no me funciona bien este método?
		String tecla;
		
		do {
			System.out.print("\n\n" + pregunta + " (s=Sí; n=No):");
			tecla = scanner.next();
			
			if (tecla.equals("s") || tecla.equals("S"))
				return true;
			if (tecla.equals("n") || tecla.equals("N"))
				return false;
			
			// si llega aquí es que no ha pulsado ninguna de las teclas correctas
			System.out.println("\n\n[ERROR]: Por favor, responde S o N");
			
		} while (true);
	}
	
	public static boolean confirmacionPorNombre(String pregunta, String objeto_nombre) {	// ¿por qué no me funciona bien este método?
		String nombre;
		boolean eliminar = false;
	
		System.out.print("\n\n" + pregunta + " : (" + objeto_nombre + ")\t");
		nombre = scanner.next();
			
		if (nombre.equals(objeto_nombre))
			eliminar = true;
		if (!nombre.equals(objeto_nombre))
			eliminar = false;
		
		return eliminar;
	}
	
	
	
	/**
	 * Parar programa.
	 */
	public static void pararPrograma() {
		System.out.println("\n\nPulse Intro para finalizar el programa.");
		scanner.next();
	}
	
}