package com.idat.EC1Servicio.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "cursos")
public class Curso {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idCurso;
	private String curso;
	private String descripcion;
	
	
	@ManyToOne
	@JoinColumn(
			name = "id_malla",nullable = false,unique = true,
			foreignKey = @ForeignKey(foreignKeyDefinition = "foreign key (id_malla) references mallacurriculares(id_malla)")
			)
	private MallaCurricular mallacurricular_cur;
	
	
	@ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
	@JoinTable(
			name ="cursos_profesores",
			joinColumns = @JoinColumn(
					name = "id_curso",nullable = false,unique = true,
					foreignKey = @ForeignKey(foreignKeyDefinition = "foreign key (id_curso) references cursos(id_curso)")
					) ,
			inverseJoinColumns = @JoinColumn(
					name = "id_profesor",nullable = false,unique = true,
					foreignKey = @ForeignKey(foreignKeyDefinition = "foreign key (id_profesor) references profesores(id_profesor)")
					) 
			)
	private List<Profesor> profesores = new ArrayList<>();
	
	public Integer getIdCurso() {
		return idCurso;
	}
	public void setIdCurso(Integer idCurso) {
		this.idCurso = idCurso;
	}
	public String getCurso() {
		return curso;
	}
	public void setCurso(String curso) {
		this.curso = curso;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	
	
	

}
