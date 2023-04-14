package servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/Sinproductos")
public class Sinproductos extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String seccion=request.getParameter("seccion");
	
		PrintWriter out=response.getWriter();
		response.setContentType("text/html");	
		out.println("<html><body><center>");
		out.println("<h1>la sección "+seccion+" no tiene productos</h1>");
		out.println("</center></body></html>");
	}

}
