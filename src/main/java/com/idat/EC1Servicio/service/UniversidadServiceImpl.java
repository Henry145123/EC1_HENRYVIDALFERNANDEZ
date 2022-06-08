package com.idat.EC1Servicio.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.idat.EC1Servicio.model.Universidad;
import com.idat.EC1Servicio.repository.UniversidadRepository;

@Service
public class UniversidadServiceImpl implements UniversidadService{

	@Autowired
	private UniversidadRepository uniRepo;
	
	@Override
	public void guardarUniversidad(Universidad u) {
		uniRepo.save(u);
		
	}

	@Override
	public void actualizarUniversidad(Universidad u) {
		uniRepo.saveAndFlush(u);
		
	}

	@Override
	public void eliminarUniversidad(Integer idUniversidad) {
		uniRepo.deleteById(idUniversidad);
		
	}

	@Override
	public List<Universidad> listaUniversidades() {
		return uniRepo.findAll();
	}

	@Override
	public Universidad obtenerUniversidadId(Integer id) {
		
		return uniRepo.findById(id).orElse(null);
	}

}
