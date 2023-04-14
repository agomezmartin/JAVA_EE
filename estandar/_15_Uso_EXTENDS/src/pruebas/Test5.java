package pruebas;

import java.util.List;

public class Test5 {

	public static void main(String[] args) {
		
		List<String> nombres = List.of("cadena","luz","día","meteoro","bicicleta");
		
		// mostrar el TOTAL DE CARACTERES de CADA NOMBRE
		System.out.println( "Cada palabra tiene el siguiente NÚMERO DE CARACTERES:");

				nombres.stream() // conversión de la LISTA a STREAM
				
				// métodos INTERMEDIOS
				.map(s -> s.length()) // cuenta la longitud de cada cadena

				// método FINAL
				.forEach(n -> System.out.println(n)// imprime el resultado de cada recuento
					);

				///////////////////////////////////
				
				System.out.println("La suma de todos los caracteres de la lista es: ");
				System.out.println(
						
						// calcular la suma de todos los caracteres de la lista
						nombres.stream() // conversión de la LISTA a STREAM
						
						.mapToInt(s -> s.length())
						.sum()
		
						);

	} // cierre MAIN

}