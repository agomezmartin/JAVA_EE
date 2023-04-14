package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import model.Pagina;

/**
 * Servlet implementation class Listado
 */
@WebServlet("/Listado")
public class Listado extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Pagina> paginas=(List<Pagina>)request.getAttribute("resultado");
		PrintWriter out=response.getWriter();
		response.setContentType("application/json");
		//instanciamos la librería Gson
		Gson gson=new Gson();
		String json=gson.toJson(paginas);
		out.println(json); //enviamos el json al cliente javascript
	}

}
