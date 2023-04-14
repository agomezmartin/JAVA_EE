package controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import model.Cliente;
import service.ClientesService;
import service.LibrosService;

@Controller
public class ClientesController {
	@Autowired
	ClientesService clientesService;
	@Autowired
	LibrosService librosService;
	@PostMapping(value="alta")	
	public String alta(@ModelAttribute("cliente") Cliente cliente) {
		clientesService.altaCliente(cliente);
		return "login";
		
	}
	@PostMapping(value="login")	
	public String login(@ModelAttribute("cliente") Cliente cliente, HttpServletRequest request) {
		if(clientesService.validarCliente(cliente.getUsuario(), cliente.getPassword())) {
			request.setAttribute("temas", librosService.obtenerTemas());
			return "temas";
		}
		return "nologin";
		
	}
	
	
}
