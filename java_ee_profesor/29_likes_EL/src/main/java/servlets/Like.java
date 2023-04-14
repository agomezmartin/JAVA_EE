package servlets;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Like
 */
@WebServlet("/Like")
public class Like extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//recogemos servletcontext y recuperamos atributo de aplicación contador
		//si no existe, se crea. En cualquier caso, se incrementa en una unidad y se vuelve
		//a actualizar
		ServletContext context=request.getServletContext();
		Integer contador=(Integer)context.getAttribute("contador");
		if(contador==null) {
			contador=0;
		}
		contador++;
		context.setAttribute("contador", contador);
		//volvemos a página de inicio
		request.getRequestDispatcher("inicio.html").forward(request, response);
	}

}
