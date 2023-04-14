package repaso;

import java.util.Collection;
import java.util.List;

public class EjercicioNombres {

	public static void main(String[] args) {


	} // cierre MAIN

	/*
	 * 
	 * Realizar un MÉTODO que reciba una LISTA DE NOMBRES y un NOMBRE
	 * y devuela el NÚMERO DE VECES que aparece el NOMBRE en la LISTA.
	 * 
	 */
		
	private static int listaNombres(List<String> lst, String nombre){
		
		int contador = 0;
		
		for (String n:lst) {
			if(n.equals(nombre)) {
				contador++;
			}
		}

		return contador;

	} // cierre método

}