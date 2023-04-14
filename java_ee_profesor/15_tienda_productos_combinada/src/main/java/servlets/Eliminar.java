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
 * Servlet implementation class Eliminar
 */
@WebServlet("/Eliminar")
public class Eliminar extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//recoge el nombre del producto a eliminar y llama a la capa de servicio para que 
		//lo elimine
		String nombre=request.getParameter("nombre");
		ProductosService service=new ProductosService();
		service.eliminarProducto(nombre);
		//volver a la p�gina de inicio
		RequestDispatcher rd=request.getRequestDispatcher("inicio.html");
		rd.forward(request, response);
	}

}
