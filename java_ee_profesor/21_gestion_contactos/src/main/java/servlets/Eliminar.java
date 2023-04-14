package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.ContactosService;

/**
 * Servlet implementation class Eliminar
 */
@WebServlet("/Eliminar")
public class Eliminar extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ContactosService service=new ContactosService();
		if(service.eliminarContacto(request.getParameter("nombre"))) {
			//transferimos el control a la página de datos
			request.getRequestDispatcher("eliminar.html").forward(request, response);
		}else {
			request.getRequestDispatcher("errorEliminar.html").forward(request, response);
		}
		
	}

}
