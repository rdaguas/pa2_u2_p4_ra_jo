package com.example.demo;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.banco.repository.modelo.CuentaBancaria;
import com.example.demo.banco.service.CuentaService;
import com.example.demo.repository.modelo.Estudiante;
import com.example.demo.service.EstudianteService;

@SpringBootApplication
public class Pa2U2P4RaJoApplication implements CommandLineRunner {
	
	@Autowired
	private CuentaService cuentaService;
	
	public static void main(String[] args) {
		SpringApplication.run(Pa2U2P4RaJoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
	CuentaBancaria bancaria = new CuentaBancaria();
	bancaria.setFechaDeApertura(LocalDateTime.now());
	bancaria.setNumero("12345");
	bancaria.setTipo("A");
	bancaria.setSaldo(new BigDecimal(100));
	bancaria.setCedulaPropietario("12344566");
	//this.cuentaService.aperturar(bancaria);
	System.out.println();
	this.cuentaService.realizar(1, bancaria.getSaldo());
	
	
	}

}
