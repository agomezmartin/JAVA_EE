package pruebas;

import java.util.List;

public class Test7 {

	public static void main(String[] args) {
		
		List<Integer> nums = List.of(9,-4,11,3,2,-6,2,5,8,17,11,1,-5);
		
		//mostrar los números de la LISTA ordenados de mayor a menor
		nums.stream()
		.sorted()
		.forEach(n -> System.out.println(n));


	} // cierre MAIN

}