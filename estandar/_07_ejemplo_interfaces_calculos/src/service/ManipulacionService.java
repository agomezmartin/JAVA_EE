package service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ManipulacionService {
	
	// crear un método que reciba una lista de números 
	// y devuelve el conjunto de todos los números pares de la lista
	
	public Set obtenerPares(List<Integer> numeros) {

		Set<Integer> res = new HashSet<>();

		for (Integer in:numeros) {
			if(in%2==0) { // número par
				res.add(in);
			}
		}
		
		return res;
	
	}

}