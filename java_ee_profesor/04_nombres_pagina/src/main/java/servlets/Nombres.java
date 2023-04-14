package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/Nombres")
public class Nombres extends HttpServlet {
	private static final long serialVersionUID = 1L;

	List<String> nombres=List.of("ana","alberto","elena","martin","carlos","lucas");
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String letra=request.getParameter("letra");
		PrintWriter out=response.getWriter();
		response.setContentType("text/html");
		out.println("<html><body>");
		nombres.stream()
		.filter(n->n.startsWith(letra))
		.forEach(n->out.println("<h1>"+n+"</h1>"));
		out.println("<a href='letra.html'>Volver</a>");
		out.println("</body></html>");
	}

}
