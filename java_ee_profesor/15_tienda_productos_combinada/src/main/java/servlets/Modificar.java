package servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.ProductosService;

/**
 * Servlet implementation class Modificar
 */
@WebServlet("/Modificar")
public class Modificar extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nombre=request.getParameter("nombre");
		double precio=(Double.parseDouble(request.getParameter("precio")));
		ProductosService service=new ProductosService();
		service.modificarPrecioProducto(nombre,precio);
		//nos dirigimos a la página de inicio
		RequestDispatcher rd=request.getRequestDispatcher("inicio.html");
		rd.forward(request, response);
	}

}
