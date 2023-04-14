package view;

import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.Scanner;

import model.Curso;
import service.CursoService;

public class CursosMenu {
	
	/////////////////////
	/*
	 * Scanner 
	 * 
	 *///////////////////
	static Scanner sc = new Scanner(System.in);

	/////////////////////
	/*
	 * Variable SERVICE 
	 * 
	 *///////////////////
	static CursoService service = new CursoService();

	/////////////////////
	/*
	 * i18n 
	 * 
	 *///////////////////
	static Locale currentLocale = new Locale("", "");
	static ResourceBundle messages = ResourceBundle.getBundle("res.ResourceBundle", currentLocale);

	public static void main(String[] args) {

		/*//////////////////////////////
		 * 	Se establece el idioma
		 *//////////////////////////////

		System.out.println(messages.getString("codigo.idioma"));
		String idioma = sc.nextLine();
		
		System.out.println(messages.getString("codigo.pais"));
		String pais = sc.nextLine();
		
		currentLocale = new Locale("" + idioma + "", "" + pais + "");
		messages = ResourceBundle.getBundle("res.ResourceBundle", currentLocale);
		
		System.out.println();

		/*//////////////////////////////
		 * 	Empieza el programa
		 *//////////////////////////////
		
		int opcion = 0;
		
		do {
			presentarMenu();
			opcion = Integer.parseInt(sc.nextLine());
			
			switch(opcion) {
			case 1:
				guardarCurso();
				break;

			case 2:
				buscarCurso();
				break;

			case 3:
				cursosTematica();
				break;
			
			case 4:
				precioMedio();
				break;
			
			case 5:
				precioMax();
				break;

			} // cierre switch

			
		} while (opcion != 6);

		System.out.println();
		System.out.println("===================");
		System.out.println(messages.getString("salir"));
		System.out.println("===================");
		System.out.println();

		
	} // cierre MAIN

	/////////////////////
	/*
	 * Métodos 
	 * 
	 *///////////////////
	private static void presentarMenu() {
		
		System.out.println(messages.getString("menu.opcion1"));
		System.out.println(messages.getString("menu.opcion2"));
		System.out.println(messages.getString("menu.opcion3"));
		System.out.println(messages.getString("menu.opcion4"));
		System.out.println(messages.getString("menu.opcion5"));
		System.out.println();
	}
	
	private static void guardarCurso() {

		String nombre, tematica;
		int duracion;
		double precio;
		
		System.out.println(messages.getString("nombre.curso"));
		nombre = sc.nextLine();
		
		System.out.println(messages.getString("tematica.curso"));
		tematica = sc.nextLine();
		
		System.out.println(messages.getString("duracion.curso"));
		duracion = Integer.parseInt(sc.nextLine());
		
		System.out.println(messages.getString("precio.curso"));
		precio = Double.parseDouble(sc.nextLine());
		
		Curso curso = new Curso(nombre, tematica, duracion, precio);
		
		if (service.agregarCurso(curso)) {
			
			System.out.println();
			System.out.println("===================");
			System.out.println(messages.getString("curso.agregado"));
			System.out.println("===================");
			System.out.println();

		} else {

			System.out.println();
			System.out.println("===================");
			System.out.println(messages.getString("curso.yaExiste"));
			System.out.println("===================");
			System.out.println();

		};

	}

	private static void buscarCurso() {
		
		String nombre;
		
		System.out.println(messages.getString("nombre.curso"));
		nombre = sc.nextLine();
		
		Curso curso = service.buscarCurso(nombre);
		
		if (curso != null) {
			
			System.out.println();
			System.out.println("===================");
			System.out.println(curso.getNombre());
			System.out.println(curso.getTematica());
			System.out.println(curso.getDuracion());
			System.out.println(curso.getPrecio());
			System.out.println("===================");
			System.out.println();
			
		} else {

			System.out.println();
			System.out.println("===================");
			System.out.println(messages.getString("curso.noExiste"));
			System.out.println("===================");
			System.out.println();
			
		}
	}
	
	private static void cursosTematica() {
		
		String tematica;
		System.out.println();
		System.out.println(messages.getString("curso.tematica"));
		tematica = sc.nextLine();
		
		List<Curso> lista =  service.cursosPorTematica(tematica);
		
		if (lista.size() > 0) { // si la lista no está vacía
			
			System.out.println();
			System.out.println("===================");
			
				for(Curso nombre:lista) {
					
					System.out.println(messages.getString("curso"));
					System.out.println(nombre.getNombre());
					System.out.println();
				}

			System.out.println("===================");
			System.out.println();
			
		} else {

			System.out.println();
			System.out.println("===================");
			System.out.println(messages.getString("tematica.noExiste"));
			System.out.println("===================");
			System.out.println();
			
		}
	}
	
	private static void precioMedio() {

		String tematica;
		System.out.println();
		System.out.println(messages.getString("curso.tematica"));
		tematica = sc.nextLine();
		
		System.out.println(messages.getString("precio.medio"));
		System.out.println(service.precioMedioTematica(tematica));

	}
	
	private static void precioMax() {
		
		Curso curso = service.cursoDuracionMax();
		
		if (curso != null) {
			
			System.out.println();
			System.out.println("===================");
			System.out.println(curso.getNombre());
			System.out.println(curso.getTematica());
			System.out.println(curso.getDuracion());
			System.out.println(curso.getPrecio());
			System.out.println("===================");
			System.out.println();
			
		} else {

			System.out.println();
			System.out.println("===================");
			System.out.println(messages.getString("curso.noExiste"));
			System.out.println("===================");
			System.out.println();
			
		}

	}

} // cierre CLASE