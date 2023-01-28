package com.AlumnosPortatiles.BLL.services.implementations;

import java.util.List;
import java.util.Scanner;

import org.springframework.stereotype.Service;

import com.AlumnosPortatiles.BLL.queries.implementations.PortatilQueryImpl;
import com.AlumnosPortatiles.BLL.queries.interfaces.IPortatilQuery;
import com.AlumnosPortatiles.BLL.services.interfaces.IPortatilService;
import com.AlumnosPortatiles.DAL.entities.Portatil;
import com.AlumnosPortatiles.tools.Tools;


@Service("PortatilServiceImpl")
public class PortatilServiceImpl implements IPortatilService {

	
	/** The scanner. */
	public static Scanner scanner = new Scanner(System.in);
	
	/** The portatil query impl. */
	IPortatilQuery portatilQueryImpl = new PortatilQueryImpl();

	// IToDTO toDtoServiceImpl = new ToDtoServiceImpl();
	
	// IToDAO toDaoServiceImpl = new ToDaoServiceImpl();
	
	
	
	/**
	 * Mostrar lista de portatiles.
	 *
	 * @throws Exception the exception
	 */
	@Override
	public void mostrarListaDePortatiles() throws Exception {
		List<Portatil> listaPortatiles = portatilQueryImpl.listarPortatiles();
		
		for (Portatil portatil : listaPortatiles) {
			System.out.println(portatil.toString());
		}
	}

	
	
	/**
	 * Mostrar un portatil.
	 *
	 * @throws Exception the exception
	 */
	@Override
	public void mostrarUnPortatil() throws Exception {
		System.out.println("\n\nLista de portatiles");
		System.out.println("------------------------------");
		mostrarListaDePortatiles();
		
		int portatil_id = Tools.capturaEntero_v3("Introduzca un número para mostrar un portatil", 0, 99);
		Portatil portatil = portatilQueryImpl.buscarPortatilPorId(portatil_id);
		System.out.println(portatil.toString());
	}

	
	
	/**
	 * Seleccionar un portatil.
	 *
	 * @return the portatil
	 * @throws Exception the exception
	 */
	@Override
	public Portatil seleccionarUnPortatil() throws Exception {
		System.out.println("\n\nLista de portatiles");
		System.out.println("------------------------------");
		mostrarListaDePortatiles();
		
		int portatil_id = Tools.capturaEntero_v3("Introduzca un número para mostrar un portatil", 0, 99);
		Portatil portatil = portatilQueryImpl.buscarPortatilPorId(portatil_id);
		
		return portatil;
	}

	
	
	/**
	 * Crear un nuevo portatil.
	 *
	 * @throws Exception the exception
	 */
	@Override
	public void crearUnNuevoPortatil() throws Exception {
		System.out.println("\n\nIntroduzca la marca del nuevo portatil");
		String portatil_marca = scanner.next();
		
		System.out.println("\n\nIntroduzca el modelo del nuevo portatil");
		String portatil_modelo = scanner.next();
		
		portatilQueryImpl.insertarPortatil(new Portatil(portatil_marca, portatil_modelo));
		System.out.println("\n\nEl nuevo portatil " + portatil_marca + " se ha registrado correctamente");
	}

	
	
	/**
	 * Editar marca modelo de un portatil.
	 *
	 * @throws Exception the exception
	 */
	@Override
	public void editarMarcaModeloDeUnPortatil() throws Exception {
		System.out.print("\n\nVamos a editar los datos de un portatil");
		Portatil portatil = seleccionarUnPortatil();
		
		System.out.print("\n\nIntroduzca una nueva marca para el portatil seleccionado:\t");
		String portatil_marca = scanner.next();
		
		System.out.print("\n\nIntroduzca un nuevo modelo para el portatil seleccionado:\t");
		String portatil_modelo = scanner.next();
		
		portatilQueryImpl.editarPortatil(portatil.getPortatil_id(), portatil_marca, portatil_modelo);
		System.out.println("\n\nEl portatil selecccionado se ha modificado correctamente");
	}

	
	
	/**
	 * Eliminar un portatil por id.
	 *
	 * @throws Exception the exception
	 */
	@Override
	public void eliminarUnPortatilPorId() throws Exception {
		System.out.print("\n\nVamos a eliminar un portatil por su ID");
		System.out.println("\n\nLista de portatiles");
		System.out.println("------------------------------");
		mostrarListaDePortatiles();
		
		int portatil_id = Tools.capturaEntero_v3("Introduzca un número para eliminar ese portatil", 0, 99);
		
		if (Tools.preguntaSiNo("¿Está seguro de que desea eliminar el portatil seleccionado?")) {
			portatilQueryImpl.eliminarPortatilPorId(portatil_id);
			System.out.println("\n\nEl portatil seleccionado se ha eliminado correctamente");
		}
		else {
			System.out.println("\n\nEl portatil seleccionado NO se ha eliminado");
		}
	}

	
	
	/**
	 * Eliminar un portatil.
	 *
	 * @throws Exception the exception
	 */
	@Override
	public void eliminarUnPortatil() throws Exception {
		System.out.print("\n\nVamos a eliminar un portatil");
		Portatil portatil = seleccionarUnPortatil();
		
		if (Tools.preguntaSiNo("¿Está seguro de que desea eliminar el portatil seleccionado?")) {
			portatilQueryImpl.eliminarPortatil(portatil);
			System.out.println("\n\nEl portatil seleccionado se ha eliminado correctamente");
		}
		else {
			System.out.println("\n\nEl portatil seleccionado NO se ha eliminado");
		}
	}

}