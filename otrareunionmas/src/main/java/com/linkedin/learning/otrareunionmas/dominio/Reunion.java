package com.linkedin.learning.otrareunionmas.dominio;

import java.time.LocalDate;
import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="reunion")
public class Reunion {
	@Column(name="id")
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name="fecha")
	private LocalDateTime fecha;
	
	@Column(name="asunto")
	private String asunto;
	
	public Reunion() {
		
	}
	public Reunion(LocalDateTime fecha, String asunto) {
		this.fecha = fecha;
		this.asunto = asunto;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public LocalDateTime getFecha() {
		return fecha;
	}
	public void setFecha(LocalDateTime fecha) {
		this.fecha = fecha;
	}
	public String getAsunto() {
		return asunto;
	}
	public void setAsunto(String asunto) {
		this.asunto = asunto;
	}
	@Override
	public String toString() {
		return "Reunion [id=" + id + ", fecha=" + fecha + ", asunto=" + asunto + "]";
	}
	
}
