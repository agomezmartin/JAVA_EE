package pk1;

public class Clase1 {
	
	// ámbito privado
	private void print1 () {
		System.out.println("print 1");
	}
	
	// ámbito de paquete
	void print2 () {
		System.out.println("print 2");
	}
	
	// ámbito protegido
	protected void print3 () {
		System.out.println("print 3");
	}
	
	// ámbito público
	public void print4 () {
		System.out.println("print 4");
	}
	
	class Case2 {
		
		public void test() {
			Clase1 c = new Clase1();
			
		}
	}

}
