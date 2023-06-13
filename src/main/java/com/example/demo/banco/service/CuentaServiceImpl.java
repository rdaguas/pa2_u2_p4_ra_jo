package com.example.demo.banco.service;

import java.math.BigDecimal;
import java.math.RoundingMode;
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

	@Override
	public void realizar(Integer id, BigDecimal saldo) {
		CuentaBancaria cuent = this.cuentaRepository.buscar(id);
		Integer ndia = cuent.getFechaDeApertura().getDayOfMonth();
		BigDecimal cuentamas;
		if(ndia %2 != 0) {
			cuentamas = cuent.getSaldo().multiply(new BigDecimal(1.05));
			this.cuentaRepository.actualizar(cuent);
		}else{
			this.cuentaRepository.actualizar(cuent);
			
			
			
			
			
		}
	}



}
