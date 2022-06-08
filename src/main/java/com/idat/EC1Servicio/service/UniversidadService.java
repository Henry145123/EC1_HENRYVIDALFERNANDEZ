package com.idat.EC1Servicio.service;

import java.util.List;

import com.idat.EC1Servicio.model.Universidad;

public interface UniversidadService {

	void guardarUniversidad(Universidad u);
	void actualizarUniversidad(Universidad u);
	void eliminarUniversidad(Integer idUniversidad);
	List<Universidad> listaUniversidades();
	Universidad obtenerUniversidadId(Integer id);
}
