package com.example.demo;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.repository.modelo.Autor;
import com.example.demo.repository.modelo.Libro;
import com.example.demo.service.AutorService;
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
		
		Autor aut = new Autor();
		aut.setNombre("Roberto");
		aut.setApellido("Aguas");
		
		Libro l1 = new Libro();
		l1.setTitulo("Caperucita");
		l1.setEditorial("Alfagura");
		

		Libro l2 = new Libro();
		l2.setTitulo("Rey Leon");
		l2.setEditorial("Literatura");
		
		Set<Libro> libros = new HashSet<>();
		//libros.add(l1);
		//libros.add(l2);
		
		Set<Autor> autores = new HashSet<>();
		//autores.add(aut);
		
		l1.setAutores(autores);
		l2.setAutores(autores);
		
		//this.autorService.agregar(aut);
		
		
		Autor aut1 = new Autor();

		aut1.setNombre("Juan");
		aut1.setApellido("Shapere");
		autores.add(aut1);
		
		Libro lib = new Libro();
		lib.setAutores(autores);
		lib.setEditorial("Juanita");
		lib.setTitulo("Pablo Neruda");
		lib.setId(2);
		
		Libro lib2 = new Libro();
		lib2.setAutores(autores);
		lib2.setEditorial("Panchata");
		lib2.setTitulo("Don quijote de la mancha");
		//lib2.setId(2);

		
		this.libroService.agregar(lib2);
		this.libroService.actualizar(lib);
		this.libroService.borrar(4);
		this.libroService.buscar(2);

		
//		Ciudadano ciud = new Ciudadano();
//		ciud.setNombre("Ramiro");
//		ciud.setApellido("Cazar");
//		ciud.setCedula("1212");
//		
//		Ciudadano ciud2 = new Ciudadano();
//		ciud2.setNombre("Catherin");
//		ciud2.setApellido("Cabezon");
//		ciud2.setCedula("9998");
//		//ciud2.setId(15);
//
//		//this.ciudadanoService.crear(ciud2);
//		//this.ciudadanoService.modificar(ciud2);
//
//
//
//		Empleado empl = new Empleado();
//		empl.setCargo("Jefe Administrativo");
//		empl.setSueldo(new BigDecimal(1000));
//		empl.setId(3);
//		empl.setCiudadano(ciud2);
//		ciud.setEmpleado(empl);
//		
//
//		this.empleadoService.agregar(empl);
//		this.empleadoService.modificar(empl);
//		//this.ciudadanoService.modificar(ciud2);
//		this.empleadoService.eliminar(4);
//		System.out.println(" Se encontro el empleado " + this.empleadoService.buscar(3));
//		

		//this.estudianteService.actualizar(estu2);
		//this.ciudadanoService.crear(ciud);
		//this.ciudadanoService.modificar(ciud2);
		//this.ciudadanoService.eliminar(1);
		//this.estudianteService.eliminar("4");
		//System.out.println(this.estudianteService.buscar("6"));
	}
}
