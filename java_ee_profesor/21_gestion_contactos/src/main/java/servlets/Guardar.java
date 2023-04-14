package servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Contacto;
import service.ContactosService;

/**
 * Servlet implementation class Guardar
 */
@WebServlet("/Guardar")
public class Guardar extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//creamos el objeto Contacto
		Contacto contacto=new Contacto(0,
				request.getParameter("nombre"),
				request.getParameter("email"), 
				Integer.parseInt(request.getParameter("edad")));
		
		//crear un objeto ContactosService para llamar a su método de alta
		ContactosService service=new ContactosService();
		if(service.altaContacto(contacto)) {
			//transferimos el control a la página de datos
			request.getRequestDispatcher("alta.html").forward(request, response);
		}else {
			request.getRequestDispatcher("errorAlta.html").forward(request, response);
		}
	}

}
