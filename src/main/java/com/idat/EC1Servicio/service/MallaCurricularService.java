package com.idat.EC1Servicio.service;

import java.util.List;

import com.idat.EC1Servicio.model.MallaCurricular;

public interface MallaCurricularService {

	void guardarMallaCurricular(MallaCurricular mc);
	void actualizarMallaCurricular(MallaCurricular mc);
	void eliminarMallaCurricular(Integer idMallaCurricular);
	List<MallaCurricular> listaMallaCurriculares();
	MallaCurricular obtenerMallaCurricularId(Integer id);
}
