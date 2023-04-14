package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Cliente;
import service.ClientesService;

/**
 * Servlet implementation class RegistrarAction
 */
@WebServlet("/RegistrarAction")
public class RegistrarAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String usuario = request.getParameter("usuario");
		String pwd = request.getParameter("pwd");
		String email = request.getParameter("email");
		Integer telefono = Integer.parseInt(request.getParameter("telefono"));
		
		ClientesService service = new ClientesService();
		service.altaCliente(new Cliente(0, usuario, pwd, email, telefono));
		

	}

}
