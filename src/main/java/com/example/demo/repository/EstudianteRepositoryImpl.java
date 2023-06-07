package com.example.demo.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.demo.repository.modelo.Estudiante;

@Repository
public class EstudianteRepositoryImpl implements EstudianteRepository {
	
	List<Estudiante>baseDatos = new ArrayList<>();

	@Override
	public void insertar(Estudiante estudiante) {
		this.baseDatos.add(estudiante);
		
		
	}

}
