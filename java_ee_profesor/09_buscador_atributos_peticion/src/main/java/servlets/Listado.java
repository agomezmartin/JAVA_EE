package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Pagina;

/**
 * Servlet implementation class Listado
 */
@WebServlet("/Listado")
public class Listado extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Pagina> paginas=(List<Pagina>)request.getAttribute("resultado");
		PrintWriter out=response.getWriter();
		response.setContentType("text/html");
		out.println("<html><body>");
		paginas
		.forEach(p->out.println("<h2><a href='"+p.getDireccion()+"'>"+p.getDireccion()+"</a></h2><h4>"+p.getDescripcion()+"</h4>"));
		out.println("<a href='datos.html'>Volver</a>");		
			
		out.println("</body></html>");
	}

}
