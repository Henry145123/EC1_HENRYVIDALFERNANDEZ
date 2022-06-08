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

import com.idat.EC1Servicio.model.Curso;
import com.idat.EC1Servicio.service.CursoServiceImpl;

@RestController
@RequestMapping(path="curso")
public class CursoRestController {

	@Autowired
	private CursoServiceImpl curServ;
	
	@RequestMapping(path = "/listar", method = RequestMethod.GET)
	public @ResponseBody ResponseEntity<List<Curso>> listarCursos(){
		return new ResponseEntity<List<Curso>>(curServ.listaCursos(),HttpStatus.OK);
	}
	
	@RequestMapping(path="/buscar/{id}",method = RequestMethod.GET)
	public ResponseEntity<Curso> buscarCurso(@PathVariable Integer id){
		Curso cur = curServ.obtenerCursoId(id);
		if(cur!=null) {
			return new ResponseEntity<Curso>(cur,HttpStatus.OK);
		}
		return new ResponseEntity<Curso>(HttpStatus.NOT_FOUND);
	}
	
	@RequestMapping(path="/guardar", method =RequestMethod.POST)
	public ResponseEntity<Void> guardarCurso(@RequestBody Curso curso){
		curServ.guardarCurso(curso);
		return new ResponseEntity<Void>(HttpStatus.CREATED);
	}
	
	@RequestMapping(path = "/actualizar", method = RequestMethod.PUT)
	public ResponseEntity<Void> actualizarCurso(@RequestBody Curso curso){
		
		Curso cur = curServ.obtenerCursoId(curso.getIdCurso());
		
		if(cur!=null) {
			curServ.actualizarCurso(curso);
			return new ResponseEntity<Void>(HttpStatus.OK);
		}
		
		return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
	}
	
	@RequestMapping(path = "/eliminar/{id}",method=RequestMethod.DELETE)
	public ResponseEntity<Void> eliminarCurso(@PathVariable Integer id){
		Curso cur = curServ.obtenerCursoId(id);
		if(cur!=null) {
			curServ.eliminarCurso(id);
			return new ResponseEntity<Void>(HttpStatus.OK);
		}
		
		return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		
	}
	
	
	
}
