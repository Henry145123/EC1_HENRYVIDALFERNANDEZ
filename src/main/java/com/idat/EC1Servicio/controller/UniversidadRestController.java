package com.idat.EC1Servicio.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.idat.EC1Servicio.model.Universidad;
import com.idat.EC1Servicio.service.UniversidadServiceImpl;

@RestController
@RequestMapping(path="universidad")
public class UniversidadRestController {

	@Autowired
	private UniversidadServiceImpl uniServ;
	
	@RequestMapping(path = "/listar", method = RequestMethod.GET)
	public @ResponseBody ResponseEntity<List<Universidad>> listarUniversidades(){
		return new ResponseEntity<List<Universidad>>(uniServ.listaUniversidades(),HttpStatus.OK);
	}
	
	@RequestMapping(path="/buscar/{id}",method = RequestMethod.GET)
	public ResponseEntity<Universidad> buscarUniversidad(@PathVariable Integer id){
		Universidad uni = uniServ.obtenerUniversidadId(id);
		if(uni!=null) {
			return new ResponseEntity<Universidad>(uni,HttpStatus.OK);
		}
		return new ResponseEntity<Universidad>(HttpStatus.NOT_FOUND);
	}
	
	@RequestMapping(path="/guardar", method =RequestMethod.POST)
	public ResponseEntity<Void> guardarUniversidad(@RequestBody Universidad universidad){
		uniServ.guardarUniversidad(universidad);
		return new ResponseEntity<Void>(HttpStatus.CREATED);
	}
	
	@RequestMapping(path = "/actualizar", method = RequestMethod.PUT)
	public ResponseEntity<Void> actualizarUniversidad(@RequestBody Universidad universidad){
		
		Universidad uni = uniServ.obtenerUniversidadId(universidad.getIdUniversidad());
		
		if(uni!=null) {
			uniServ.actualizarUniversidad(universidad);
			return new ResponseEntity<Void>(HttpStatus.OK);
		}
		
		return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
	}
	
	@RequestMapping(path = "/eliminar/{id}",method=RequestMethod.DELETE)
	public ResponseEntity<Void> eliminarUniversidad(@PathVariable Integer id){
		Universidad uni = uniServ.obtenerUniversidadId(id);
		if(uni!=null) {
			uniServ.eliminarUniversidad(id);
			return new ResponseEntity<Void>(HttpStatus.OK);
		}
		
		return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		
	}
	
	
	
}
