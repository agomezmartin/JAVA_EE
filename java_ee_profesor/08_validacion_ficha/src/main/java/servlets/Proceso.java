package servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Ficha;

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
		//recuperamos la ficha
		Ficha ficha=(Ficha)request.getAttribute("ficha");
		PrintWriter out=response.getWriter();
		response.setContentType("text/html");
		out.println("<html><body>");
		out.println("<h1>Usuario "+ficha.getUsuario()+"</h1>");
		out.println("<h1>Email "+ficha.getEmail()+"</h1>");
		out.println("<h1>Edad "+ficha.getEdad()+"</h1>");
		out.println("<a href='login.html'>Volver</a>");
		out.println("</body></html>");
		
	}

}
