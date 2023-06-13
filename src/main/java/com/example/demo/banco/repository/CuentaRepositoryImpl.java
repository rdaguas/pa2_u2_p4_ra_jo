package com.example.demo.banco.repository;

import org.springframework.stereotype.Repository;

import com.example.demo.banco.repository.modelo.CuentaBancaria;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class CuentaRepositoryImpl implements CuentaRepository {
	
	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public void insertar(CuentaBancaria cuenta) {
		this.entityManager.persist(cuenta);
		
	}

	@Override
	public void actualizar(CuentaBancaria cuenta) {
		this.entityManager.merge(cuenta);
		
	}

	@Override
	public CuentaBancaria buscar(Integer id) {

		return this.entityManager.find(CuentaBancaria.class, id);
	}

}
