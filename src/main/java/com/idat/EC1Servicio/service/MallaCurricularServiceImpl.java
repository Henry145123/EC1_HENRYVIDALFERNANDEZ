package com.idat.EC1Servicio.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.idat.EC1Servicio.model.MallaCurricular;
import com.idat.EC1Servicio.repository.MallaCurricularRepository;

@Service
public class MallaCurricularServiceImpl implements MallaCurricularService {

	@Autowired
	private MallaCurricularRepository mcRepo;
	
	@Override
	public void guardarMallaCurricular(MallaCurricular mc) {
		mcRepo.save(mc);
	}

	@Override
	public void actualizarMallaCurricular(MallaCurricular mc) {
		mcRepo.saveAndFlush(mc);
	}

	@Override
	public void eliminarMallaCurricular(Integer idMallaCurricular) {
		mcRepo.deleteById(idMallaCurricular);
	}

	@Override
	public List<MallaCurricular> listaMallaCurriculares() {
		return mcRepo.findAll();
	}

	@Override
	public MallaCurricular obtenerMallaCurricularId(Integer id) {
		return mcRepo.findById(id).orElse(null);
	}

}
