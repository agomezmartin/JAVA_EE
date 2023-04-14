package Prueba;

import java.util.function.Predicate;

public class Test {
	
	interface I1 {
		String print(int n);
	}

	interface I2 {
		boolean cast(int a, String m);
	}

	// realizar dos implementaciones de cada interfaz utilizando expresiones LAMBDA

	/*
	 * Realiza dos implementaciones de PREDICATE:
	 * 
	 * 1. Una para números enteros: devolverá TRUE si el número es PAR
	 * 2. Otra para cadenas: devolverá TRUE si la cadena empieza POR "A".
	 * 
	 */

	public static void main(String[] args) {
	
		Predicate<Integer> enteros = a -> a%2==0;
		Predicate<String> cadena = a -> a.startsWith("a");
		

	} // cierre MAIN

}
