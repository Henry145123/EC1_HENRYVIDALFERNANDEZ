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

import com.idat.EC1Servicio.model.MallaCurricular;
import com.idat.EC1Servicio.service.MallaCurricularServiceImpl;

@RestController
@RequestMapping(path="mallacurricular")
public class MallaCurricularRestController {

	@Autowired
	private MallaCurricularServiceImpl mcServ;
	
	@RequestMapping(path = "/listar", method = RequestMethod.GET)
	public @ResponseBody ResponseEntity<List<MallaCurricular>> listarMallaCurriculares(){
		return new ResponseEntity<List<MallaCurricular>>(mcServ.listaMallaCurriculares(),HttpStatus.OK);
	}
	
	@RequestMapping(path="/buscar/{id}",method = RequestMethod.GET)
	public ResponseEntity<MallaCurricular> buscarMallaCurricular(@PathVariable Integer id){
		MallaCurricular mc = mcServ.obtenerMallaCurricularId(id);
		if(mc!=null) {
			return new ResponseEntity<MallaCurricular>(mc,HttpStatus.OK);
		}
		return new ResponseEntity<MallaCurricular>(HttpStatus.NOT_FOUND);
	}
	
	@RequestMapping(path="/guardar", method =RequestMethod.POST)
	public ResponseEntity<Void> guardarMallaCurricular(@RequestBody MallaCurricular mallaCurricular){
		mcServ.guardarMallaCurricular(mallaCurricular);
		return new ResponseEntity<Void>(HttpStatus.CREATED);
	}
	
	@RequestMapping(path = "/actualizar", method = RequestMethod.PUT)
	public ResponseEntity<Void> actualizarMallaCurricular(@RequestBody MallaCurricular mallaCurricular){
		
		MallaCurricular mc = mcServ.obtenerMallaCurricularId(mallaCurricular.getIdMalla());
		
		if(mc!=null) {
			mcServ.actualizarMallaCurricular(mallaCurricular);
			return new ResponseEntity<Void>(HttpStatus.OK);
		}
		
		return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
	}
	
	@RequestMapping(path = "/eliminar/{id}",method=RequestMethod.DELETE)
	public ResponseEntity<Void> eliminarMallaCurricular(@PathVariable Integer id){
		MallaCurricular mc = mcServ.obtenerMallaCurricularId(id);
		if(mc!=null) {
			mcServ.eliminarMallaCurricular(id);
			return new ResponseEntity<Void>(HttpStatus.OK);
		}
		
		return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		
	}
	
	
	
}
