package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Libro;
import service.LibrosService;


/**
 * Servlet implementation class LibrosAction
 */
@WebServlet("/LibrosAction")
public class LibrosAction extends HttpServlet {
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int idTema=Integer.parseInt(request.getParameter("idTema"));
	
		LibrosService service=new LibrosService();
		
		List<Libro> libros;
		//si idTema es 0 es que ha elegido todos
		if(idTema==0){
			libros=service.recuperarLibros();
		}
		else{
			libros=service.recuperarLibros(idTema);
		}
		request.setAttribute("libros", libros);
		
	}

}
