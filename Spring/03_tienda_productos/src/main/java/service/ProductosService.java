package service;

import java.util.List;

import model.Producto;

public interface ProductosService {

	//devuelve la lista de productos de la secci�n que le llegue como par�metro
	List<Producto> productosSeccion(String seccion);

	//el m�todo recibe los datos de un producto y lo da de alta en la lista
	void altaProducto(Producto producto);

	//localiza la posici�n del producto que tiene ese nombre
	//y lo borra por posici�n
	void eliminarProducto(String nombre);

	//localizar el producto por su nombre y establecerle el nuevo precio
	void modificarPrecioProducto(String nombre, double nuevoPrecio);

}