package pruebas;

@FunctionalInterface
// interfaz
interface Oper{
	void print();
}

//una implementación que genere mensaje de saludo
class Impl implements Oper {
	
	public void print() {
		System.out.println("Hello");
	}
	
}

//una implementación que genere mensaje con los días de la semana
class Impl2 implements Oper {
	
	public void print() {
		System.out.println("Lunes, martes, miércoles, jueves");
	}
	
}

// clase con MÉTODO MAIN
public class Test {

	public static void main(String[] args) {
		
		// crear y llamar a los métodos
		Oper op1 = new Impl();
		op1.print();
		
		Oper op2 = new Impl2();
		op2.print();
		


	} // cierre MAIN

}