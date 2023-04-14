package dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import model.Movimiento;

public interface MovimientosDao extends JpaRepository<Movimiento,Integer>{
	List<Movimiento> findByIdCuenta(int numeroCuenta);
	
}
