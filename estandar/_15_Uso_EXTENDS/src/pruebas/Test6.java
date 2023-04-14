package pruebas;

import java.util.List;

public class Test6 {

	public static void main(String[] args) {
		
		List<Integer> edades = List.of(5,19,27,75,23,11,6,64,49);
		
		// mostrar la EDAD MEDIA de las personas MENORES DE EDAD
		System.out.println( "la EDAD MEDIA de las personas MENORES DE EDAD es:");
		
		System.out.println(
				
				edades.stream() // conversión de la LISTA a STREAM
				
				// métodos INTERMEDIOS
				.filter(n -> n < 18) // filtra los MENORES de edad
				.mapToInt(n -> n)
				.average()
				
				// método FINAL
				.getAsDouble())
	;

	} // cierre MAIN

}