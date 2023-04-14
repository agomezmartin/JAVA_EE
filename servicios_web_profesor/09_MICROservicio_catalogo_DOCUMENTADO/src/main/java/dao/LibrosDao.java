package dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import model.Libro;

public interface LibrosDao extends JpaRepository<Libro, Integer> {
	
	List<Libro> findByIdTema(int idTema);
	
	@Query("update Libro l set l.precio=l.precio*((?1+100)/100) where l.idTema=?2")
	@Modifying
	@Transactional
	void updatePrecio(double porcentaje, int iTema);



}