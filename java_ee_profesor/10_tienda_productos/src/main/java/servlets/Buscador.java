package servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Producto;
import service.ProductosService;

/**
 * Servlet implementation class Buscador
 */
@WebServlet("/Buscador")
public class Buscador extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//recupera el par�metro con el nombre de secci�n introducido, para despu�s
		//obtener la lista de productos de esa secci�n (a trav�s de la capa de servicio)
		//y guardar esa lista en un atributo de petici�n para transferir despu�s el control
		//al servlet de Listado
	
		String seccion=request.getParameter("seccion");
		ProductosService service=new ProductosService();
		List<Producto> prods=service.productosSeccion(seccion);
		if(!prods.isEmpty()) {
			request.setAttribute("productos", prods);
			//transferimos petici�n al servlet Listado
			RequestDispatcher rd=request.getRequestDispatcher("Listado");
			rd.forward(request, response);
		}else {
			request.getRequestDispatcher("Sinproductos").forward(request, response);
		}
		
	}

}
