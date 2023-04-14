package service;

import java.util.ArrayList;
import java.util.List;

import model.Producto;

public class Carrito {
	private List<Producto> productos=new ArrayList<>();
	
	public List<Producto> getProductos() {
		return productos;
	}

	public boolean agregar(Producto producto) {
		return productos.add(producto);
		
	}

}
