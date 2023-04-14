package pruebas;

// dada esta interfac funcional
@FunctionalInterface
interface Opera {
	void print();
}

// crea dos implementaciones de la interfaz, una que muestre mensaje de saludo
// y otra los días de la semana. Después llamamos a los métodos

// clase con MÉTODO MAIN
public class TestLambda {

	public static void main(String[] args) {
		
		Opera op1 = () -> System.out.println("Hello");
		op1.print();
		
		Opera op2 = () -> System.out.println("Lunes, martes, miércoles, jueves");
		op2.print();
	}

}
