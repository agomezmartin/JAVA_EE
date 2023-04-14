package controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

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
	@GetMapping(value="libros",produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody List<Libro> libros(@RequestParam("idTema") int idTema) {
		if(idTema==0) {
			return librosService.recuperarLibros();
		}else {
			return librosService.recuperarLibros(idTema);
		}		
	}
	@GetMapping(value="agregar",produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody List<Libro> agregarCarrito(@RequestParam("isbn") int isbn,HttpSession sesion ) {
		Libro lib=librosService.buscarLibroPorIsbn(isbn);
		//agregamos el libro al carrito	
		List<Libro> carrito=(List<Libro>)sesion.getAttribute("carrito");
		if(carrito==null) { //si carrito no existe se crea
			carrito=new ArrayList<>();
			sesion.setAttribute("carrito", carrito);
		}
		carrito.add(lib);
		return carrito;
	}
	@GetMapping(value="eliminar",produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody List<Libro> eliminarCarrito(@RequestParam("posicion") int posicion,HttpSession sesion ) {		
		//agregamos el libro al carrito	
		List<Libro> carrito=(List<Libro>)sesion.getAttribute("carrito");
		if(carrito!=null) {
			carrito.remove(posicion);
		}
		return carrito;
	}
}
