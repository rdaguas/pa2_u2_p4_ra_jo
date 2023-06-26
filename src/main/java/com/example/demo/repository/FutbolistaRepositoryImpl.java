package com.example.demo.repository;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.demo.repository.modelo.Estudiante;
import com.example.demo.repository.modelo.Futbolista;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class FutbolistaRepositoryImpl implements FutbolistaRepository{
	
	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public void insertar(Futbolista futbolista) {
		this.entityManager.persist(futbolista);
		
	}

	@Override
	public void actualizar(Futbolista futbolista) {
		this.entityManager.merge(futbolista);
		
	}

	@Override
	public void borrar(String cedula) {
		Futbolista fut = this.seleccionar(cedula);
		this.entityManager.remove(fut);
		
		
	}

	@Override
	public Futbolista seleccionar(String cedula) {
		return this.entityManager.find(Futbolista.class, cedula);
	}

	@Override
	public Futbolista seleccionarPorApellido(String apellido) {
		//SQL
		//SELECT * FROM estudiante WHERE e.estu_apellido = '';
		//JPQL: SE MANTIENE LAS PALABRAS RESERVADAS
		//SELECT e FROM Estudiante e WHERE e."nombre del atributo" e.apellido=
		//Cuando uso query debo usar un CAST en el return
		Query myQuery = this.entityManager.createQuery("SELECT f FROM Futbolista f WHERE f.apellido= :datoApellido");
		myQuery.setParameter("datoApellido", apellido);
		return (Futbolista) myQuery.getSingleResult();
		
	}

	@Override
	public Futbolista seleccionarPorApellidoyNombreTyped(String apellido, String nombre) {
		TypedQuery<Futbolista> myQuery =  this.entityManager.createQuery("SELECT f FROM Futbolista f WHERE f.apellido= :datoApellido AND f.nombre = :datoNombre", Futbolista.class);
		myQuery.setParameter("datoApellido", apellido);
		myQuery.setParameter("datoNombre", nombre);
		return myQuery.getSingleResult();
		
	}

	@Override
	public Futbolista seleccionarPorPrecio(BigDecimal precio) {
		Query myQuery = this.entityManager.createQuery("SELECT f FROM Futbolista f WHERE f.precioFutbolista= :datoPrecio");
		myQuery.setParameter("datoPrecio", precio);
		return (Futbolista) myQuery.getSingleResult();
	}

	@Override
	public List<Futbolista> seleccionarListaPorPrecio(BigDecimal precio) {
		Query myQuery = this.entityManager.createQuery("SELECT f FROM Futbolista f WHERE f.precioFutbolista= :datoPrecio");
		myQuery.setParameter("datoPrecio", precio);
		return myQuery.getResultList();
	}

	@Override
	public List<Futbolista> seleccionarPorApellidoTyped(String apellido) {
		TypedQuery myQuery = this.entityManager.createQuery("SELECT f FROM Futbolista f WHERE f.apellido= :datoApellido", Futbolista.class);
		myQuery.setParameter("datoApellido", apellido);
		return myQuery.getResultList();
	}

}
