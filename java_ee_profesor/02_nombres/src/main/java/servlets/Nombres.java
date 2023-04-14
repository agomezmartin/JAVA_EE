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
	String[] letras= {"a","e","i","c"};
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//genera una página que muestre los nombres que comiencen
		//por una letra, aleatoriamente, del array
		int pos=(int)(Math.random()*letras.length);//aleatorio entre 0 y 3
		PrintWriter out=response.getWriter();
		response.setContentType("text/html");
		out.println("<html><body>");
		nombres.stream()
		.filter(n->n.startsWith(letras[pos]))
		.forEach(n->out.println("<h1>"+n+"</h1>"));
		out.println("</body></html>");
	}

}
