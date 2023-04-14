package servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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
			//guardar el usuario en un atributo de sesión
			HttpSession s=request.getSession();
			s.setAttribute("usuario", user);
			
			//usuario válido
			dispatcher=request.getRequestDispatcher("inicio.html");
			
		}else {
			//usuario no válido
			dispatcher=request.getRequestDispatcher("error.jsp");
			
		}
		dispatcher.forward(request, response);
	}

}
