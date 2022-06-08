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

import com.idat.EC1Servicio.model.Profesor;
import com.idat.EC1Servicio.service.ProfesorServiceImpl;

@RestController
@RequestMapping(path="profesor")
public class ProfesorRestController {

	@Autowired
	private ProfesorServiceImpl proServ;
	
	@RequestMapping(path = "/listar", method = RequestMethod.GET)
	public @ResponseBody ResponseEntity<List<Profesor>> listarProfesores(){
		return new ResponseEntity<List<Profesor>>(proServ.listaProfesores(),HttpStatus.OK);
	}
	
	@RequestMapping(path="/buscar/{id}",method = RequestMethod.GET)
	public ResponseEntity<Profesor> buscarProfesor(@PathVariable Integer id){
		Profesor pro = proServ.obtenerProfesorId(id);
		if(pro!=null) {
			return new ResponseEntity<Profesor>(pro,HttpStatus.OK);
		}
		return new ResponseEntity<Profesor>(HttpStatus.NOT_FOUND);
	}
	
	@RequestMapping(path="/guardar", method =RequestMethod.POST)
	public ResponseEntity<Void> guardarProfesor(@RequestBody Profesor profesor){
		proServ.guardarProfesor(profesor);
		return new ResponseEntity<Void>(HttpStatus.CREATED);
	}
	
	@RequestMapping(path = "/actualizar", method = RequestMethod.PUT)
	public ResponseEntity<Void> actualizarProfesor(@RequestBody Profesor profesor){
		
		Profesor pro = proServ.obtenerProfesorId(profesor.getIdProfesor());
		
		if(pro!=null) {
			proServ.actualizarProfesor(profesor);
			return new ResponseEntity<Void>(HttpStatus.OK);
		}
		
		return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
	}
	
	@RequestMapping(path = "/eliminar/{id}",method=RequestMethod.DELETE)
	public ResponseEntity<Void> eliminarCurso(@PathVariable Integer id){
		Profesor pro = proServ.obtenerProfesorId(id);
		if(pro!=null) {
			proServ.eliminarProfesor(id);
			return new ResponseEntity<Void>(HttpStatus.OK);
		}
		
		return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		
	}
	
	
	
}
