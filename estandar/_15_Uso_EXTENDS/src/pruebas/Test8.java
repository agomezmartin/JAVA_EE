package pruebas;

import java.util.Comparator;
import java.util.List;

public class Test8 {

	public static void main(String[] args) {
		
		List<Integer> nums=List.of(9,-4,11,3,2,-6,2,5,8,17,11,1,-5);
		//mostrar los números de la lista ordenados de menor a mayor
		nums.stream()
		.sorted()
		.forEach(n->System.out.println(n));
		/////////////////////////////////////////
		
		List<String> nombres=List.of("cadena","luz","dia","meteoro","bicicleta");
		//mostrar nombres ordenados alfabeticamente
		/*nombres.stream()
		.sorted()
		.forEach(n->System.out.println(n));*/
		
		//mostrar nombres ordenados de menor a mayor número de caracteres
		nombres.stream()
		//.sorted((a,b)->a.length()-b.length())
		.sorted(Comparator.comparingInt(a->a.length()))
		.forEach(n->System.out.println(n));
		

	} // cierre MAIN

}