package pruebas;

import java.util.List;

public class Test1 {

	public static void main(String[] args) {
		
		List<Integer> nums = List.of(9,-4,11,3,2,-6,2,5,8,17,11,1,-5);
		
		// ¿Cuántos números ÚNICOS hay en la lista?
		System.out.println( "Hay " +
				
				nums.stream() // conversión de la LISTA a STREAM
				
				// método INTERMEDIO
				.distinct() // busca los números ÚNICOS: método INTERMEDIO
				
				// método FINAL
				.count() // CUENTA los números únicos: método FINAL
				
				+ " números únicos en la lista."
				);

	} // cierre MAIN

}
