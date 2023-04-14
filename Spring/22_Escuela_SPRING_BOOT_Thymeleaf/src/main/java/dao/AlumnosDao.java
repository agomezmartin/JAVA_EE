package dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import model.Alumno;

public interface AlumnosDao extends JpaRepository<Alumno, Integer>{
	
	// crear método que permita BUSCAR alumnos por CURSO
	// el NOMBRE DEL MÉTODO (estándard de SPRING) sirve para LLAMAR al método que implementa SPRING
	// y que usa para operar contra la base de datos
	public List<Alumno> opfindByCurso(int curso);
	
}