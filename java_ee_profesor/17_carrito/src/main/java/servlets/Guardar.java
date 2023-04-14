package servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Producto;
import service.Carrito;

/**
 * Servlet implementation class Guardar
 */
@WebServlet("/Guardar")
public class Guardar extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// recoger datos
		String nombre = request.getParameter("producto");
		
		HttpSession sesion = request.getSession();
		
		Carrito carrito = (Carrito) sesion.getAttribute("carrito");
		//si es la primera vez, o la sesión ha expirado, se tiene que crear el carrito
		if (carrito == null) {
			carrito = new Carrito();
			sesion.setAttribute("carrito", carrito);					
		}
		//se añade el nuevo producto al carrito
		carrito.agregar(new Producto(nombre));
		request.getRequestDispatcher("inicio.html").forward(request, response);
	}

	

}
