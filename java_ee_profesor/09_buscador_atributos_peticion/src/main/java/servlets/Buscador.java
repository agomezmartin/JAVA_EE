package servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Pagina;
import service.BuscadorService;

/**
 * Servlet implementation class Buscador
 */
@WebServlet("/Buscador")
public class Buscador extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		
		//recogemos parametro
		String tema=request.getParameter("tema");
		BuscadorService service=new BuscadorService();
		List<Pagina> resultado=service.buscarPaginas(tema);
		if(!resultado.isEmpty()) {
			//guardamos la lista de resultados de páginas en atributo de petición
			request.setAttribute("resultado", resultado);
			request.getRequestDispatcher("Listado").forward(request, response);
		}else {
			request.getRequestDispatcher("Sinpaginas").forward(request, response);
		}
		
		
	}

}
