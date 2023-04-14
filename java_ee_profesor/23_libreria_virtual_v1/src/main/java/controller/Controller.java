package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Controller
 */
@WebServlet("/Controller")
public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String option = request.getParameter("option");
		String urlVista = "login.html";
		
		switch(option) {
			case "doLogin":
				// usamos include para llamar y regresar
				request.getRequestDispatcher("LoginAction").include(request, response);
				urlVista=(Boolean)request.getAttribute("resultado")?"entrada.jsp":"nologin.html";				
				break;
			case "doRegistrar":
				request.getRequestDispatcher("RegistrarAction").include(request, response);
				urlVista="login.html";
				break;
			case "toRegistro":
				urlVista="registro.html";
				break;
			case "toLogin":
				urlVista="login.html";
				break;
		}
		
		request.getRequestDispatcher(urlVista).forward(request, response);
	}


	

}
