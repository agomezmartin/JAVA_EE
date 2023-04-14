package pruebas;

import java.util.ArrayList;
import java.util.List;

public class TestRemoveIf {

	public static void main(String[] args) {
		
		List<Integer> list = new ArrayList<>(List.of(8,-2,-1,6,5,11,40,5));
		
		list.removeIf(n -> n<0);


		
	}

}
