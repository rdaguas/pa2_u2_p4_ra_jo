package com.example.demo.banco.service;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.banco.repository.CuentaRepository;
import com.example.demo.banco.repository.modelo.CuentaBancaria;

@Service
public class CuentaServiceImpl implements CuentaService {
	
	@Autowired
	private CuentaRepository cuentaRepository;
	
	@Override
	public void aperturar(CuentaBancaria cuenta) {
		CuentaBancaria cuent = this.cuentaRepository.buscar(cuenta.getId());
		LocalDateTime n = cuent.getFechaDeApertura();
	//Integer nDia = n.getDayOfMonth();
		//if(nDia %2 ==0) {
		//BigDecimal calcular = cuent.getSaldo().
		//	 this.cuentaRepository.insertar(cuenta);
		//else {
			 this.cuentaRepository.insertar(cuenta);
			
		
		
		
		
		
		
		
	}

	@Override
	public void actualizar(CuentaBancaria cuenta) {
		this.cuentaRepository.actualizar(cuenta);
		
	}

	@Override
	public CuentaBancaria consultarSaldo(Integer id) {
		// TODO Auto-generated method stub
		return this.cuentaRepository.buscar(id);
	}

}
