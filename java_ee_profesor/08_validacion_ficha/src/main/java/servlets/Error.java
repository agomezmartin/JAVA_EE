package servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Error
 */
@WebServlet("/Error")
public class Error extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String usuario=request.getParameter("usuario");
		String pwd=request.getParameter("pwd");
		PrintWriter out=response.getWriter();
		response.setContentType("text/html");
		out.println("<html><body>");
		out.println("<h1>Error, la combinación "+usuario+" y "+pwd+" no es correcta</h1>");
		out.println("<a href='login.html'>Volver</a>");
		out.println("</body></html>");
	}

}
