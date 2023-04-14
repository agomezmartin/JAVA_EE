package servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Sinpaginas
 */
@WebServlet("/Sinpaginas")
public class Sinpaginas extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//recogemos parametro
		String tema=request.getParameter("tema");
		PrintWriter out=response.getWriter();
		response.setContentType("text/html");
		out.println("<html><body>");
		out.println("<h1>No se encuentran páginas para el tema "+tema+"</h1>");
		out.println("<a href='datos.html'>Volver</a>");		
		
		out.println("</body></html>");
	}

}
