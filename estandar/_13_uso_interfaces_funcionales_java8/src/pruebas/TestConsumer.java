package pruebas;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class TestConsumer {
	
	// Método que IMPRIMA los números POSITIVOS de una lista
	// Método que GUARDE los números PARES de una lista
	// Método que ENVÍE POR UNA RED los números POSITIVOS de una lista

	private static void procesarCondicion(
			List<Integer> list,
			Consumer<Integer> proceso,
			Predicate<Integer> condicion) {
		
		for(Integer num:list) {
			
			if(condicion.test(num)) { // implementación de PREDICATE
				proceso.accept(num); // implementación de CONSUMER
			}
		
		}
	} // cierre método procesarcondicion()
	
	/*
	 * MÉTODO MAIN
	 */
	public static void main(String[] args) {
		
		List<Integer> nums = List.of(5,4,9,1,-3,8,-5,-6);
		
		// imprime los números POSITIVOS

		procesarCondicion(
				nums, // lista de NÚMEROS
				n -> System.out.println(n), // CONSUMER
				n -> n>=0 // PREDICATE
				);

	} // cierre MAIN
	
}
