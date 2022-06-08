package com.idat.EC1Servicio.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.idat.EC1Servicio.model.Curso;
import com.idat.EC1Servicio.repository.CursoRepository;

@Service
public class CursoServiceImpl implements CursoService{

	
	@Autowired
	private CursoRepository curRepo;
	
	@Override
	public void guardarCurso(Curso c) {
		curRepo.save(c);	
	}

	@Override
	public void actualizarCurso(Curso c) {
		curRepo.saveAndFlush(c);
	}

	@Override
	public void eliminarCurso(Integer idCurso) {
		curRepo.deleteById(idCurso);
	}

	@Override
	public List<Curso> listaCursos() {
		return curRepo.findAll();
	}

	@Override
	public Curso obtenerCursoId(Integer id) {
		return curRepo.findById(id).orElse(null);
	}
	

}
