package com.example.demo.repository.modelo.dto;

import jakarta.persistence.Column;

public class EstudianteDTO {
	
	//Estos son los atributos exclusivos como yo elegi
	private String nombre;
	
	private String apellido;


	public EstudianteDTO() {
		
	}
	//Paso1, debe tener un constructor de los atributos , constructorFields
	public EstudianteDTO(String nombre, String apellido) {
		super();
		this.nombre = nombre;
		this.apellido = apellido;
	}


	//Set and Get
	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public String getApellido() {
		return apellido;
	}


	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	@Override
	public String toString() {
		return "EstudianteDTO [nombre=" + nombre + ", apellido=" + apellido + "]";
	}
	
	
	
	
	

}
