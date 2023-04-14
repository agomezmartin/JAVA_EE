package servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Proceso
 */
@WebServlet("/Proceso")
public class Proceso extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String usuario=request.getParameter("usuario");
		PrintWriter out=response.getWriter();
		response.setContentType("text/html");
		out.println("<html><body>");
		out.println("<h1>Bienvenido a mi página "+usuario+"</h1>");
		out.println("<a href='login.html'>Volver</a>");
		out.println("</body></html>");
		
	}

}
