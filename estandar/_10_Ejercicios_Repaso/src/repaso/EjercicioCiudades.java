package repaso;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import model.Ciudad;

/*
 * Realizar TRES métodos:
 * 
 * 1. Recibe una LISTA DE CIUDADES y devuelve la ciudad más calurosa.
 * 
 * 2. Recibe una LISTA DE CIUDADES y una TEMPERATURA.
 * Devuelve un CONJUNTO con las ciudades cuya temperatura sea inferior a dicho parámetro.
 * 
 * 3. recibe una LISTA DE CIUDADES. Devuelve la TEMPERATURA MEDIA.
 * 
 * Una CIUDAD es un JavaBean que ENCAPSULA el NOMBRE y TEMPERATURA de una ciudad.
 * 
 * 
 */

public class EjercicioCiudades {

	public static void main(String[] args) {


	} // cierre MAIN
	
	// ciudad más calurosa
	// 1. Recibe una LISTA DE CIUDADES y devuelve la ciudad más calurosa.
	
	public static Ciudad ciudadCalurosa(List<Ciudad> lst) {
		
		Ciudad ciudadMax = null;
		double tempMax;
		
		for(Ciudad ciudad:lst) {
			
			if(ciudad.getTemperatura()>tempMax) {
				
			}

		}
		
		
		
		
		return ciudad;
	}

	// CONJUNTO de ciudades cuya etmperatura es menor que el parámetro
	// 2. Recibe una LISTA DE CIUDADES y una TEMPERATURA.
	// Devuelve un CONJUNTO con las ciudades cuya temperatura sea inferior a dicho parámetro.

	private static Set<Ciudad> conjuntoCiudades(List<String> lst, double temp) {
		
		HashSet<Ciudad> conjunto = HashSet<>();

		
		
		return conjunto;
	}
	
	// ciudad más calurosa
	// 3. recibe una LISTA DE CIUDADES. Devuelve la TEMPERATURA MEDIA.

	private static double temperaturaMedia(List<String> lst) {
		
		double media = 0;

		
		
		return media;
	}

}