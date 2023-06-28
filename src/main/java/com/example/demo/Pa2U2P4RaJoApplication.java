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
import com.example.demo.repository.modelo.Estudiante;
import com.example.demo.repository.modelo.Habitacion;
import com.example.demo.repository.modelo.Hotel;
import com.example.demo.repository.modelo.Libro;
import com.example.demo.repository.modelo.Materia;
import com.example.demo.repository.modelo.Matricula;
import com.example.demo.service.AutorService;
import com.example.demo.service.CiudadanoService;
import com.example.demo.service.EmpleadoService;
import com.example.demo.service.EstudianteService;
import com.example.demo.service.HabitacionService;
import com.example.demo.service.HotelService;
import com.example.demo.service.LibroService;
import com.example.demo.service.MatriculaService;

@SpringBootApplication
public class Pa2U2P4RaJoApplication implements CommandLineRunner {
	
	@Autowired
	private EstudianteService estudianteService;
	
	public static void main(String[] args) {
		SpringApplication.run(Pa2U2P4RaJoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		List<Estudiante> est = this.estudianteService.buscarListaPorApellido("Ortega");
		//System.out.println(est);
		
		//Estudiante estuApellidoyNombre = this.estudianteService.seleccionarPorApellidoyNombre("Ramos", "Felipe");
		//System.out.println(estuApellidoyNombre);
		
	//	Estudiante ty = this.estudianteService.seleccionarPorApellidoTyped("Ramos");

		
		Estudiante estu = new Estudiante();
		estu.setNombre("Felipe");
		estu.setApellido("Ramos");
		estu.setCedula("17243");
		
		Estudiante estu2 = new Estudiante();
		estu2.setNombre("Jimmy");
		estu2.setApellido("Ortega");
		estu2.setCedula("10");
		
		//this.estudianteService.guardar(estu);
		
		System.out.println("************************************ QUERY ************************************");
		System.out.println(this.estudianteService.buscarPorApellido("Ortega"));
		
		System.out.println("************************************ TYPED QUERY ************************************");
		System.out.println(this.estudianteService.seleccionarPorApellidoTypedQuery("Valencia"));
		
		System.out.println("************************************ NAMED QUERY ************************************");
		System.out.println(this.estudianteService.seleccionarPorApellidoNamedQuery("Aguas"));
		System.out.println(this.estudianteService.seleccionarPorNombreNamedQuery("Daniel"));
		
		
		
	//	System.out.println(this.estudianteService.seleccionarPorApellidoNamed("Aguas"));
		
		
		//this.estudianteService.eliminar("17243");
		
		//System.out.println(this.estudianteService.seleccionarPorApellidoNativeQuery("Ramos"));
		
		
		
		//System.out.println(this.estudianteService.buscarListaPorApellido("Ortega"));
		
		//System.out.println(this.estudianteService.seleccionarPorApellidoTypedNativeQuery("Ramos"));
		
//		public Estudiante seleccionarPorNombreNamedQuery(String nombre);
//		
//		public Estudiante seleccionarPorNombreTypedNativeQuery(String nombre);
		//System.out.println(this.estudianteService.seleccionarPorNombreNamedQuery("Felipe"));
		
		System.out.println(this.estudianteService.seleccionarPorNombreTypedNativeQuery("Felipe"));
		
		

	}
	
	

}
