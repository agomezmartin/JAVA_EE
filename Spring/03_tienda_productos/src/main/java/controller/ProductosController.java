package controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import model.Producto;
import service.ProductosService;

@Controller
public class ProductosController {
	@Autowired
	ProductosService productosService;
	
	@PostMapping(value="alta")
	public String alta(@RequestParam("nombre") String nombre, 
			@RequestParam("seccion") String seccion, 
			@RequestParam("precio") double precio, 
			@RequestParam("stock") int stock) {
		Producto prod=new Producto(nombre,seccion,precio,stock);
		productosService.altaProducto(prod);
		return "inicio";
	}
	
	@PostMapping(value="Eliminar")
	public String eliminar(	@RequestParam("nombre") String nombre) {
		
		productosService.eliminarProducto(nombre);	
		
		return "inicio";
	}
	
	@PostMapping(value="Modificar")
	public String modificar(	@RequestParam("nombre") String nombre,
								@RequestParam("precio") Double precio) {
		
		productosService.modificarPrecioProducto(nombre, precio);	
		
		return "inicio";
	}
					
	@GetMapping(value="Buscar")
	public String buscar(	@RequestParam("seccion") String seccion,
							HttpServletRequest request) {
		
		List<Producto> prods = productosService.productosSeccion(seccion);
		if (!prods.isEmpty()) {
			// pasamos la lista de productos en el atributo de request (porque la necesita listado.jsp)
			request.setAttribute("productos", prods);
			return "listado";
		}
		return "sinproductos";
		
	}


}
