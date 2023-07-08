package com.example.demo.repository.modelo.dto;

public class MatriculaDTO {
	
	private String nombreA;
	private String nombreM;
	
	public MatriculaDTO() {
		
	}
	
	public MatriculaDTO(String nombreA, String nombreM) {
		super();
		this.nombreA = nombreA;
		this.nombreM = nombreM;
	}

	public String getNombreA() {
		return nombreA;
	}

	public void setNombreA(String nombreA) {
		this.nombreA = nombreA;
	}

	public String getNombreM() {
		return nombreM;
	}

	public void setNombreM(String nombreM) {
		this.nombreM = nombreM;
	}

	@Override
	public String toString() {
		return "MatriculaDTO [nombreA=" + nombreA + ", nombreM=" + nombreM + "]";
	}
	
	

}
