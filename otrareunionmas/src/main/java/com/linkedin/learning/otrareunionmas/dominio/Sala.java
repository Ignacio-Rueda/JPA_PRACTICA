package com.linkedin.learning.otrareunionmas.dominio;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="sala")
public class Sala {
	@Id
	@Column(length=20)
	private String id;
	private String descripcion;
	private int capacidad;
	
	
	public Sala() {
		
	}
	
	public Sala(String id,String descripcion,int capacidad) {
		this.id = id;
		this.descripcion = descripcion;
		this.capacidad = capacidad;
	}
	
	private String getId() {
		return id;
	}
	private void setId(String id) {
		this.id = id;
	}
	private String getDescripcion() {
		return descripcion;
	}
	private void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	private int getCapacidad() {
		return capacidad;
	}
	private void setCapacidad(int capacidad) {
		this.capacidad = capacidad;
	}
	
	
	
	

}
