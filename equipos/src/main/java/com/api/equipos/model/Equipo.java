package com.api.equipos.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Entity
public class Equipo {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	@NotNull
	private String nombre;
	@NotBlank(message = "Debe ingresar un valor")
	private String liga;
	@NotBlank(message = "Debe ingresar un valor")
	private String pais;
	

	public Equipo(Integer id, String nombre, String liga, String pais) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.liga = liga;
		this.pais = pais;
	}
	
	public Equipo() {
		super();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getLiga() {
		return liga;
	}

	public void setLiga(String liga) {
		this.liga = liga;
	}

	public String getPais() {
		return pais;
	}

	public void setPais(String pais) {
		this.pais = pais;
	}

}
