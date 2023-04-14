package dao;

import org.springframework.data.jpa.repository.JpaRepository;

import model.Curso;

/*
 * No se necesitan métodos porque el FINDALL() se hereda de JpaRepository
 * 
 */

public interface CursosDao extends JpaRepository<Curso, Integer> {

}
