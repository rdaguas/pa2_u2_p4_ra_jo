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

import com.example.demo.repository.modelo.Futbolista;
import com.example.demo.service.FutbolistaService;

@SpringBootApplication
public class Pa2U2P4RaJoApplication implements CommandLineRunner {

	@Autowired
	private FutbolistaService futbolistaService;

	public static void main(String[] args) {
		SpringApplication.run(Pa2U2P4RaJoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// Tarea 7 Query y TypedQuery
		Futbolista futb = new Futbolista();
		futb.setNombre("Sergio");
		futb.setApellido("Ramos");
		futb.setPrecioFutbolista(new BigDecimal(6000));

		Futbolista futb2 = new Futbolista();
		futb2.setNombre("Enner");
		futb2.setApellido("Valencia");
		futb2.setPrecioFutbolista(new BigDecimal(3000));

		//this.futbolistaService.guardar(futb);
		// this.futbolistaService.guardar(futb2);
		// Llamo por Apellido
		// Query con Single Result
		System.out.println("-------------------QUERY SINGLE RESULT - POR APELLIDO -------------------");
		System.out.println(this.futbolistaService.buscarPorApellido("Messi"));
		// Llamo por Precio del Jugador
		// Query con Single result
		System.out.println("-------------------QUERY SINGLE RESULT - POR PRECIO -------------------");
		System.out.println(this.futbolistaService.seleccionarPorPrecio(new BigDecimal(1000)));
		// Busco por precio, con ResultList();
		System.out.println("------------------- QUERY  RESULT LIST  - POR PRECIO -------------------");
		List<Futbolista> fut = this.futbolistaService.seleccionarListaPorPrecio(new BigDecimal(2000));
		System.out.println(fut);
		//Busco por Apellido y Nombre, con TypedQuery - single result
		System.out.println("------------------- TYPEDQUERY  SINGLE RESULT  - POR APELLIDO Y NOMBRE -------------------");
		Futbolista futApellidoyNombre = this.futbolistaService.seleccionarPorApellidoyNombreTyped("Ramos", "Sergio");
		System.out.println(futApellidoyNombre);
		//Busco por Apellido, con TypedQuery - RESULLT LIST
		System.out.println("------------------- TYPEDQUERY  RESULT LIST - POR APELLIDO -------------------");
		List<Futbolista> futTy = this.futbolistaService.seleccionarPorApellidoTyped("Valencia");
		System.out.println(futTy);

	}

}
