package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Registro
 */
@WebServlet("/Registro")
public class Registro extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		response.setContentType("text/html");
		out.println("<html><body>");
		//recogemos parámetros
		String nombre=request.getParameter("nombre");
		String email=request.getParameter("email");
		int edad=Integer.parseInt(request.getParameter("edad"));
		String sexo=request.getParameter("sexo");
		String[] preferencias=request.getParameterValues("prefes");
		out.println("Bienvenido: "+sexo+nombre+" tu email es: "+email+" tienes "+edad);
		out.println("<br>Has elegido: ");
		//recorrer el array y mostrar cada preferencia
		/*if(preferencias!=null) {
			for(String n:preferencias) {
				out.println(n+"<br>");
			}
		}*/
		
			Arrays.stream(preferencias!=null?preferencias:new String[]{})
			.forEach(n->out.println(n+"<br>"));
		
		out.println("</body></html>");
		
	}

}
