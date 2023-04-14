package servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Producto;
import service.ProductosService;

/**
 * Servlet implementation class Alta
 */
@WebServlet("/Alta")
public class Alta extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//recoger los parametros que me env�a la p�gina de alta
		//y llamar con ellos al m�todo de alta de la capa de servicio
		
		
		String nombre=request.getParameter("nombre");
		String seccion=request.getParameter("seccion");
		double precio=(Double.parseDouble(request.getParameter("precio")));
		int stock=(Integer.parseInt(request.getParameter("stock")));
		Producto producto=new Producto(nombre, seccion, precio, stock);
		ProductosService service= new ProductosService ();
		service.altaProducto(producto);
		//transferir el control a la p�gina de alta
		RequestDispatcher rd=request.getRequestDispatcher("alta.html");
		rd.forward(request, response);
	}

}
