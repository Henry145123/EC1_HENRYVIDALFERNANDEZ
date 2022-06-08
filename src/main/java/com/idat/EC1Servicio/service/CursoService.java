package com.idat.EC1Servicio.service;

import java.util.List;

import com.idat.EC1Servicio.model.Curso;

public interface CursoService {
	void guardarCurso(Curso c);
	void actualizarCurso(Curso c);
	void eliminarCurso(Integer idCurso);
	List<Curso> listaCursos();
	Curso obtenerCursoId(Integer id);
}
