package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Producto;

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
		//recupera la lista de productos que est� en el atributo "productos"
		List<Producto> productos=(List<Producto>)request.getAttribute("productos");
		//crear una tabla HTML con los datos de cada producto
		PrintWriter out=response.getWriter();
		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");
		out.println("<html><body><center>");
		out.println("<table border='1'><tr><th>Nombre</th><th>Precio</th><th>Stock</th></tr>");
		//recogemos cada producto de la colecci�n lista y dibujamos una fila con sus datos
		
		productos.forEach(pd->out.println("<tr><td>"+pd.getNombre()+"</td><td>"+pd.getPrecio()+"</td><td>"+pd.getStock()+"</td></tr>"));
		
		out.println("</table><br>");
		out.println("<a href='datos.html'>Volver</a>");
		out.println("</center></body></html>");
		
		
	}

}
