package com.idat.EC1Servicio.model;

import javax.persistence.*;

@Entity
@Table(name="universidades")
public class Universidad {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idUniversidad;
	
	private String universidad;
	
	@OneToOne
	@JoinColumn(
			name = "id_malla",nullable = false,unique = true,
			foreignKey = @ForeignKey(foreignKeyDefinition = "foreign key (id_malla) references mallacurriculares(id_malla)")
			)
	private MallaCurricular mallacurricular;
	
	
	public Integer getIdUniversidad() {
		return idUniversidad;
	}
	public void setIdUniversidad(Integer idUniversidad) {
		this.idUniversidad = idUniversidad;
	}
	public String getUniversidad() {
		return universidad;
	}
	public void setUniversidad(String universidad) {
		this.universidad = universidad;
	}
	
	
}
