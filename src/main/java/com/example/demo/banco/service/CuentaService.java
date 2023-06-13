package com.example.demo.banco.service;

import java.math.BigDecimal;

import com.example.demo.banco.repository.modelo.CuentaBancaria;

public interface CuentaService {
	
	public void aperturar(CuentaBancaria cuenta);
	public void actualizar(CuentaBancaria cuenta);
	public CuentaBancaria consultarSaldo(Integer id);
	
	public void realizar(Integer id, BigDecimal saldo);
}
