package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Controller
 */
@WebServlet("/Controller")
public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String option=request.getParameter("option");
		String urlVista="menu.html";
		switch(option) {
			case "doAlta":
				request.getRequestDispatcher("AltaAction").include(request, response);
				urlVista="menu.html";
				break;
			case "doEliminar":
				request.getRequestDispatcher("EliminarAction").include(request, response);
				urlVista="menu.html";
				break;
			case "doListado":
				request.getRequestDispatcher("ListadoAction").include(request, response);
				urlVista="listado.jsp";
				break;
			case "toAlta":
				urlVista="alta.html";
				break;
			case "toEliminar":
				urlVista="eliminar.html";
				break;
			case "toMenu":
				urlVista="menu.html";
				break;
		}
		request.getRequestDispatcher(urlVista).forward(request, response);
	}

}
