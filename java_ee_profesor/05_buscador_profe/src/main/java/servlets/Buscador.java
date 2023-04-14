package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Pagina;

/**
 * Servlet implementation class Buscador
 */
@WebServlet("/Buscador")
public class Buscador extends HttpServlet {
	private static final long serialVersionUID = 1L;

	List<Pagina> paginas=List.of(new Pagina("http://www.casadellibro.es", "libros","Libros y más cosas"),
			new Pagina("http://www.gamers.es", "juegos","Todo sobre video juegos"),
			new Pagina("http://www.computerall.es", "informática","Ordenadores al mejor precio"),
			new Pagina("http://www.fnac.es", "libros","Bienvenido al mundo del ocio y la cultura"),
			new Pagina("http://www.books.es", "libros","Entra en el mundo del libro"),
			new Pagina("http://www.pcnew.es", "informática","El paraiso del PC"));
	
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		//genere una página Web con las direcciones de las páginas que coinciden con el tema de busqueda
		//enviado desde datos.html
		PrintWriter out=response.getWriter();
		response.setContentType("text/html");
		out.println("<html><body>");
		//recogemos parametro
		String tema=request.getParameter("tema");
		//recorremos la lista de páginas y si la tematica de alguna de esas p�ginas
		//coincide con el parámetro, entonces hay que mostrar esa direcci�n en la página de respuesta
		paginas.stream()
		.filter(p->p.getTematica().equals(tema))
		.forEach(p->out.println("<h2><a href='"+p.getDireccion()+"'>"+p.getDireccion()+"</a></h2><h4>"+p.getDescripcion()+"</h4>"));
		out.println("<a href='datos.html'>Volver</a>");		
			
		out.println("</body></html>");
		
		
	}

}
