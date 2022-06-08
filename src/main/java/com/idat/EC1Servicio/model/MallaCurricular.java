package com.idat.EC1Servicio.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.*;


@Entity
@Table(name = "mallacurriculares")
public class MallaCurricular {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idMalla;
	private Date año;
	
	@OneToOne(mappedBy = "mallacurricular")	
	private Universidad universidad;
	
	
	@OneToMany(mappedBy ="mallacurricular_cur" )
	private List<Curso> cursos = new ArrayList<>();	
	
	
	
	public Integer getIdMalla() {
		return idMalla;
	}
	public void setIdMalla(Integer idMalla) {
		this.idMalla = idMalla;
	}
	public Date getAño() {
		return año;
	}
	public void setAño(Date año) {
		this.año = año;
	}
	
	
	
	
	
	

}
