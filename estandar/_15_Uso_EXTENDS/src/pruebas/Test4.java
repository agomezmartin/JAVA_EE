package pruebas;

import java.util.List;

public class Test4 {

	public static void main(String[] args) {
		
		List<Integer> nums = List.of(9,-4,11,3,2,-6,2,5,8,17,11,1,-5);
		
		// ¿Hay algún número NEGATIVO?
		System.out.println( "¿Cuántos números NEGATIVOS hay?");
		System.out.println(

				nums.stream() // conversión de la LISTA a STREAM
				
				// métodos INTERMEDIOS
				.filter(n -> n<0) // busca los números NEGATIVOS
				.distinct() // eliminna los REPETIDOS
				
				// método FINAL
				.count() // cuento los números

				);

	} // cierre MAIN

}