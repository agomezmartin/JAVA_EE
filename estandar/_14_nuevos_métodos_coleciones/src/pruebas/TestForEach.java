package pruebas;

import java.util.List;

public class TestForEach {

	public static void main(String[] args) {

		List<Integer> list = List.of(8,-2,-1,6,5,11,40,5);
	
		// mostrar los números de la lista
		list.forEach(n -> System.out.println(n));

	}

}
