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

import com.example.demo.repository.modelo.Autor;
import com.example.demo.repository.modelo.Ciudadano;
import com.example.demo.repository.modelo.Empleado;
import com.example.demo.repository.modelo.Habitacion;
import com.example.demo.repository.modelo.Hotel;
import com.example.demo.repository.modelo.Libro;
import com.example.demo.service.AutorService;
import com.example.demo.service.CiudadanoService;
import com.example.demo.service.EmpleadoService;
import com.example.demo.service.HabitacionService;
import com.example.demo.service.HotelService;
import com.example.demo.service.LibroService;

@SpringBootApplication
public class Pa2U2P4RaJoApplication implements CommandLineRunner {
	
	@Autowired
	private LibroService libroService;
	
	@Autowired
	private AutorService autorService;
	
	public static void main(String[] args) {
		SpringApplication.run(Pa2U2P4RaJoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		Set<Autor>listaAut = new HashSet<>();
		
		Autor aut1 = new Autor();

		aut1.setNombre("Juan");
		aut1.setApellido("Shapere");
		listaAut.add(aut1);
		
		//this.autorService.agregar(aut1);
		
	
		
		Libro lib = new Libro();
		lib.setAutores(listaAut);
		lib.setEditorial("Lala");
		lib.setTitulo("Don quijote");
		
		this.libroService.agregar(lib);
		
	
	
		
		
	}
	
	

}
