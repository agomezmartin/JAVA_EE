package controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import model.Contacto;
import service.ContactosService;

@Controller
public class ContactosController {
	@Autowired
	ContactosService contactosService;
	@PostMapping(value="alta")
	/*public String alta(@RequestParam("nombre") String nombre,
			@RequestParam("email") String email,
			@RequestParam("edad") int edad) {
		Contacto contacto=new Contacto(0, nombre, email, edad);
		contactosService.altaContacto(contacto);
		return "menu";
		
	}*/
	public String alta(@ModelAttribute("contacto") Contacto contacto) {
		contactosService.altaContacto(contacto);
		return "menu";
		
	}
	
	@PostMapping(value="eliminar")
	public String eliminar(@RequestParam("nombre") String nombre) {
		
		contactosService.eliminarContacto(nombre);
		return "menu";
	}
	@GetMapping(value="contactos")
	public String contactos(HttpServletRequest request) {
		request.setAttribute("contactos", contactosService.contactos());
		return "listado";
	}
}
