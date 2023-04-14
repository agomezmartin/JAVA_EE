package prueba;

public class Punto {
	
	private int x, y;
	
	public Punto(int x, int y) {

		this.x = x;
		this.y = y;

	}
	
	public Punto() {

		this.x = 5;
		this.y = 3;

	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}
	
	public void dibujar() {
		
		System.out.print("coordenadas: " + x + ", " + y);
	
	}

}
