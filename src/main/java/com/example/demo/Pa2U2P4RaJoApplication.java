package com.example.demo;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.repository.modelo.Ciudadano;
import com.example.demo.repository.modelo.Empleado;
import com.example.demo.repository.modelo.Estudiante;
import com.example.demo.repository.modelo.Habitacion;
import com.example.demo.repository.modelo.Hotel;
import com.example.demo.service.CiudadanoService;
import com.example.demo.service.EmpleadoService;
import com.example.demo.service.EstudianteService;
import com.example.demo.service.HabitacionService;
import com.example.demo.service.HotelService;

@SpringBootApplication
public class Pa2U2P4RaJoApplication implements CommandLineRunner {
	

	@Autowired
	private HabitacionService habitacionService;

	@Autowired
	private HotelService hotelService;


	public static void main(String[] args) {
		SpringApplication.run(Pa2U2P4RaJoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		Hotel hote = new Hotel();
		hote.setDireccion("Las casas");
		hote.setNombre("Oro verde");

		Habitacion habi = new Habitacion();
		habi.setHotel(hote);
		habi.setNumero("26a");
		habi.setValor(new BigDecimal(500));
		habi.setId(1);
		
		
		Habitacion habi2 = new Habitacion();
		habi2.setHotel(hote);
		habi2.setNumero("18a");
		habi2.setValor(new BigDecimal(400));
		

		this.habitacionService.crear(habi2);		
		this.habitacionService.modificar(habi);
		this.habitacionService.eliminar(6);		
		//System.out.println("Se ha encontrado "+ this.habitacionService.buscar(1));
		
		

		
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
