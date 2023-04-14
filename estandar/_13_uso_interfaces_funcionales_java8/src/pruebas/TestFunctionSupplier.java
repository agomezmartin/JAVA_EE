package pruebas;

import java.util.List;
import java.util.function.BinaryOperator;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;

public class TestFunctionSupplier {

	// método que a partir de una lista SUME a cada elemento el VALOR EXTRAÍDO DE UN FICHERO
	// método que a partir de una lista MULTIPLIQUE a cada elemento UN VALOR CREADO ALEATORIAMENTE
	
	private static void operarLista(List<Integer> list,
			BinaryOperator<Integer> oper,
			Supplier<Integer> sup) {
		
		for(int i=0; i<list.size();i++) {
			
			list.set(
					i,
					oper.apply(
							list.get(i),
							sup.get()
							)
					);

		}
		
	} // cierre operarlista()
	
	/*
	 * MÉTODO MAIN
	 */
	public static void main(String[] args) {

		List<Integer> nums = List.of(5,4,9,1,-3,8,-5,-6);
		
		operarLista(
				nums, // lista de NÚMEROS
				(a,b) -> a*b, // parámetro de UNARY OPERATOR
				() -> (int)(Math.random()*100) // parámetro de SUPPLIER
				);

	} // cierre MAIN
	
}
