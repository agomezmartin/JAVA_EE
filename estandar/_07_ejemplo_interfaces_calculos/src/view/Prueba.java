package view;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.Vector;

import service.ManipulacionService;

public class Prueba {

	public static void main(String[] args) {
		
		ManipulacionService service = new ManipulacionService();
		
		//ejemplo de una lista
		List<Integer> lista1 = List.of(3,9,10,4);

		// ejemplo de otra lista
		ArrayList<Integer> lista2 = new ArrayList<>();
		lista2.add(7);lista2.add(8);lista2.add(5);lista2.add(1);

		// ejemplo de otra lista
		Vector<Integer> lista3 = new Vector<>();
		lista3.add(14);lista3.add(2);lista3.add(6);lista3.add(3);
		
		
		//llamada al método con una lista (Vector)
		Set<Integer> res1 = service.obtenerPares(lista3);
		mostrarResultado(res1);
		//llamada al método con otra lista (ArrayList)
		mostrarResultado(service.obtenerPares(lista2));

		//llamada al método con otra lista (List)
		mostrarResultado(service.obtenerPares(lista3));

	} // cierre MAIN

	
	public static void mostrarResultado(Set<Integer> datos) {

		for(Integer in:datos) {
			System.out.print(in + ", ");
		}
		System.out.println();
		System.out.println("-----------");
	
	}
}
