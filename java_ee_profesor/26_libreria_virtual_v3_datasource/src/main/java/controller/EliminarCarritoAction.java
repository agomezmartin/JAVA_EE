package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Libro;

/**
 * Servlet implementation class EliminarCarritoAction
 */
@WebServlet("/EliminarCarritoAction")
public class EliminarCarritoAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//recogemos la posición del que se quiere eliminar
		int pos=Integer.parseInt(request.getParameter("posicion"));
		//recuperamos carrito y eliminamos
		HttpSession s=request.getSession();
		List<Libro> carrito=(List<Libro>)s.getAttribute("carrito");
		if(carrito!=null) {
			carrito.remove(pos);
		}
	}

}
