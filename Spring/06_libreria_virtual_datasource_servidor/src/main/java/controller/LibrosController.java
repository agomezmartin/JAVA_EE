package controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import model.Libro;
import service.LibrosService;
@Controller
public class LibrosController {
	@Autowired
	LibrosService librosService;
	@GetMapping(value="temas")
	public String temas(HttpServletRequest request) {
		request.setAttribute("temas", librosService.obtenerTemas());
		return "temas";
	}
	@GetMapping(value="libros")
	public String libros(@RequestParam("idTema") int idTema, HttpServletRequest request) {
		if(idTema==0) {
			request.setAttribute("libros", librosService.recuperarLibros());
		}else {
			request.setAttribute("libros", librosService.recuperarLibros(idTema));
		}
		
		return "libros";
	}
	@GetMapping(value="agregar")
	public String agregarCarrito(@RequestParam("isbn") int isbn,HttpSession sesion ) {
		Libro lib=librosService.buscarLibroPorIsbn(isbn);
		//agregamos el libro al carrito	
		List<Libro> carrito=(List<Libro>)sesion.getAttribute("carrito");
		if(carrito==null) { //si carrito no existe se crea
			carrito=new ArrayList<>();
			sesion.setAttribute("carrito", carrito);
		}
		carrito.add(lib);
		return "forward:/libros"; //transfiere la petición al controller que recupera los libros
	}
	@GetMapping(value="eliminar")
	public String eliminarCarrito(@RequestParam("posicion") int posicion,HttpSession sesion ) {		
		//agregamos el libro al carrito	
		List<Libro> carrito=(List<Libro>)sesion.getAttribute("carrito");
		if(carrito!=null) {
			carrito.remove(posicion);
		}
		return "forward:/libros";
	}
}
