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

import model.Contacto;
import service.ContactosService;

/**
 * Servlet implementation class Listado
 */
@WebServlet("/ListadoAction")
public class ListadoAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ContactosService service=new ContactosService();
		List<Contacto> contactos=service.contactos();	
		PrintWriter out=response.getWriter();
		response.setContentType("application/json");
		//instanciamos la librería Gson
		Gson gson=new Gson();
		String json=gson.toJson(contactos);
		out.println(json); //enviamos el json al cliente javascript
	}

}
