package controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import model.Ficha;

@RestController
public class SaludoController {
	
	@GetMapping(value="saludo", produces=MediaType.TEXT_PLAIN_VALUE)
	public String misaludo() {
		return "Bienvenido a mi servicio REST";
	}
	
	@GetMapping(value="saludo/{n}", produces=MediaType.TEXT_PLAIN_VALUE)
	public String saludoPersonalizado(@PathVariable("n") String nombre) {
		return "Bienvenido a REST Sr./a " + nombre;
	}
	
	@GetMapping(value="saludoNuevo", produces=MediaType.TEXT_PLAIN_VALUE)	
	public String saludoNuevo(@RequestParam("nombre") String nombre,
			@RequestParam("edad") int edad) {
		
		return "Nombre: " + nombre + " Edad: " + edad;
	}
	
	@GetMapping(value="ficha/{nombre}", produces=MediaType.APPLICATION_JSON_VALUE)
	public Ficha ficha(@PathVariable("nombre") String nombre) {
		return new Ficha(nombre, "prueba@gmail.com", 22);
	}

}
