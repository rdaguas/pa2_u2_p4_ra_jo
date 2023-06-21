package com.example.demo;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.repository.modelo.Alumno;
import com.example.demo.repository.modelo.Autor;
import com.example.demo.repository.modelo.Ciudadano;
import com.example.demo.repository.modelo.Empleado;
import com.example.demo.repository.modelo.Habitacion;
import com.example.demo.repository.modelo.Hotel;
import com.example.demo.repository.modelo.Libro;
import com.example.demo.repository.modelo.Materia;
import com.example.demo.repository.modelo.Matricula;
import com.example.demo.service.AutorService;
import com.example.demo.service.CiudadanoService;
import com.example.demo.service.EmpleadoService;
import com.example.demo.service.HabitacionService;
import com.example.demo.service.HotelService;
import com.example.demo.service.LibroService;
import com.example.demo.service.MatriculaService;

@SpringBootApplication
public class Pa2U2P4RaJoApplication implements CommandLineRunner {
	
	@Autowired
	private MatriculaService matriculaService;
	
	public static void main(String[] args) {
		SpringApplication.run(Pa2U2P4RaJoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		
		
		List<Materia>mates = new ArrayList<>();
		Materia mate = new Materia();
		Materia mate2 = new Materia();
		mate.setNombre("Analisis");
		mate2.setNombre("P_Avanzada");
		mates.add(mate);
		mates.add(mate2);
		
		List<Alumno>alums = new ArrayList<>();
		Alumno alum = new Alumno();
		Alumno alum2 = new Alumno();
		alum.setNombre("Roberto");
		alum2.setNombre("Jimmy");
		alums.add(alum);
		alums.add(alum2);
		
		Matricula matri = new Matricula();
		matri.setNumero("100");
		matri.setAlumno(alum);
		matri.setMateria(mate2);
		matri.setFecha(LocalDateTime.now());
		
		this.matriculaService.agregar(matri);
		
		
	
		
		
	}
	
	

}
