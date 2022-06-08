package com.idat.EC1Servicio.service;

import java.util.List;

import com.idat.EC1Servicio.model.Profesor;

public interface ProfesorService {

	void guardarProfesor(Profesor p);
	void actualizarProfesor(Profesor p);
	void eliminarProfesor(Integer idProfesor);
	List<Profesor> listaProfesores();
	Profesor obtenerProfesorId(Integer id);
}
