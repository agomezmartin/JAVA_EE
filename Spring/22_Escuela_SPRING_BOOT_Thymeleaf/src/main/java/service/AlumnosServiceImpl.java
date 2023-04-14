package service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.AlumnosDao;
import model.Alumno;

@Service
public class AlumnosServiceImpl implements AlumnosService {
	
	@Autowired
	AlumnosDao alumnosDao;

	@Override
	public Alumno altaAlumno(Alumno alumno) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void eliminarAlumno(String dni) {
		// TODO Auto-generated method stub

	}

	@Override
	public void cambiarCurso(String dni, int idCurso) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<Alumno> buscarAlumno(int idCurso) {
		// TODO Auto-generated method stub
		return null;
	}

}
