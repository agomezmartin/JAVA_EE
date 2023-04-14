package controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import model.Pagina;
import service.BuscadorService;

@Controller
public class BuscadorController {
	//inyecta un objeto de la capa service
	@Autowired
	@Qualifier("buscadorServiceImpl") //esta anotación se usa en caso de que haya más de un objeto
									//y quisieras indicar cual de ellos quieres
	BuscadorService buscadorService;
	@PostMapping("Buscador")
	public String buscar(@RequestParam("tema") String tema,HttpServletRequest request) {
		List<Pagina> paginas=buscadorService.buscar(tema);
		if(!paginas.isEmpty()) {
			request.setAttribute("resultado", paginas);
			return "listado";
		}
		else {
			return "sinpaginas";
		}
	}
	@PostMapping("Alta")
	public String alta(@RequestParam("direccion") String direccion,
			@RequestParam("tema") String tema,
			@RequestParam("descripcion") String descripcion) {
		Pagina pagina=new Pagina(direccion,tema,descripcion);
		buscadorService.altaPagina(pagina);
		return "datos";
	}
	
	
}
