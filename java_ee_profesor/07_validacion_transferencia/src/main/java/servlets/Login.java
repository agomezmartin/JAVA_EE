package servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Login
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//autentica usuario y tranfiere petición al servlet correspondiente
		String user=request.getParameter("usuario");
		String pwd=request.getParameter("pwd");
		RequestDispatcher dispatcher;
		if(user.equals("admin")&&pwd.equals("admin")) {
			//usuario válido
			//dispatcher=request.getRequestDispatcher("Proceso");
			//redireccionamos a página externa
			response.sendRedirect("http://www.amazon.es?user="+user);
		}else {
			//usuario no válido
			dispatcher=request.getRequestDispatcher("Error");
			dispatcher.forward(request, response);
		}
		
	}

}
