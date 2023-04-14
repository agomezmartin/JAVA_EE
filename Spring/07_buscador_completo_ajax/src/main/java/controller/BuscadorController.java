package controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import model.Pagina;
import service.BuscadorService;

@Controller
public class BuscadorController {
	//inyecta un objeto de la capa service
	@Autowired
	@Qualifier("buscadorServiceImpl") //esta anotación se usa en caso de que haya más de un objeto
									//y quisieras indicar cual de ellos quieres
	BuscadorService buscadorService;
	@PostMapping(value="Buscador",produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody List<Pagina> buscar(@RequestParam("tema") String tema) {
		List<Pagina> paginas=buscadorService.buscar(tema);
		return paginas;
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
