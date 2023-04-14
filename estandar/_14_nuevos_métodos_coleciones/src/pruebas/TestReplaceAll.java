package pruebas;

import java.util.List;

public class TestReplaceAll {

	public static void main(String[] args) {

		List<Integer> list = List.of(8,-2,-1,6,5,11,40,5);
	
		// transformar la lista en sus cuadrados y luego lo mostramos
		list.replaceAll(n -> n*n); // recibe cada número y lo multiplica por sí mismo
		
		// mostrar los números de la lista
		list.forEach(n -> System.out.println(n));

	}

}
