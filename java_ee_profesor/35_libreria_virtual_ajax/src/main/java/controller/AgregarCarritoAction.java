package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;

import model.Libro;
import service.LibrosService;

/**
 * Servlet implementation class AgregarCarritoAction
 */
@WebServlet("/AgregarCarritoAction")
public class AgregarCarritoAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//recogemos isbn y obtenemos resto de datos del libro
		int isbn=Integer.parseInt(request.getParameter("isbn"));
		LibrosService service=new LibrosService();
		Libro lib=service.buscarLibroPorIsbn(isbn);
		//agregamos el libro al carrito
		HttpSession s=request.getSession();
		List<Libro> carrito=(List<Libro>)s.getAttribute("carrito");
		if(carrito==null) { //si carrito no existe se crea
			carrito=new ArrayList<>();
			s.setAttribute("carrito", carrito);
		}
		carrito.add(lib);
		PrintWriter out=response.getWriter();
		response.setContentType("application/json");
		Gson gson=new Gson();
		out.println(gson.toJson(carrito));
	}

}
