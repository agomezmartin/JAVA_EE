package prueba;

public class Punto3D extends Punto {
	
	private int z;
	
	public Punto3D (int x, int y, int z) {
		super(x,y);
		this.z = z;
	}

	@Override
	public void dibujar() {
		// llamada al método de Punto
		super.dibujar();
		// añadimos el valor de la Z
		System.out.println(", " + z);
	}

	/*
	public void dibujar() {
		
		System.out.print("coordenadas: " + super.getX() + ", " + super.getY() + ", " + z);
	
	}
	*/
	
	

}