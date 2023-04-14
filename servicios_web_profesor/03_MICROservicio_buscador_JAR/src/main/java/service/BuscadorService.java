package service;

import java.util.List;

import model.Pagina;

public interface BuscadorService {
	List<Pagina> buscar(String tematica);
	List<Pagina> todas();
	void altaPagina(Pagina pagina);
	Pagina nuevaPagina(Pagina pagina);
	Pagina eliminarPagina(String direccion);
	Pagina actualizarPagina(Pagina pagina);
}
