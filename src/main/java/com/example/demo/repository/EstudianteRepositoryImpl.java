package com.example.demo.repository;


import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.demo.repository.modelo.Estudiante;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class EstudianteRepositoryImpl implements EstudianteRepository {

	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public void insertar(Estudiante estudiante) {
		this.entityManager.persist(estudiante);
		
	}

	@Override
	public void actualizar(Estudiante estudiante) {
		this.entityManager.merge(estudiante);
		
	}

	@Override
	public void borrar(String cedula) {
		Estudiante estu = this.seleccioanr(cedula);
		this.entityManager.remove(estu);
		
	}

	@Override
	public Estudiante seleccioanr(String cedula) {
		
		return this.entityManager.find(Estudiante.class, cedula);
	}

	@Override
	public Estudiante seleccionarPorApellido(String apellido) {
		//SQL
		//SELECT * FROM estudiante WHERE e.estu_apellido = '';
		//JPQL: SE MANTIENE LAS PALABRAS RESERVADAS
		//SELECT e FROM Estudiante e WHERE e."nombre del atributo" e.apellido=
		//Cuando uso query debo usar un CAST en el return
		Query myQuery = this.entityManager.createQuery("SELECT e FROM Estudiante e WHERE e.apellido= :datoApellido");
		myQuery.setParameter("datoApellido", apellido);
		return  (Estudiante) myQuery.getSingleResult();
	}

	@Override
	public List<Estudiante> seleccionarListaPorApellido(String apellido) {
		//QUERY JPQL
		Query myQuery = this.entityManager.createQuery("SELECT e FROM Estudiante e WHERE e.apellido =: datoApellido");
		myQuery.setParameter("datoApellido", apellido);
		return myQuery.getResultList();
	}

	@Override
	public Estudiante seleccionarPorApellidoyNombre(String apellido, String nombre) {
		//QUERY JPQL
		Query myQuery = this.entityManager.createQuery("SELECT e FROM Estudiante e WHERE e.apellido= :datoApellido AND e.nombre = :datoNombre");
		myQuery.setParameter("datoApellido", apellido);
		myQuery.setParameter("datoNombre", nombre);
		return (Estudiante) myQuery.getSingleResult();
	}

	@Override
	public Estudiante seleccionarPorApellidoTyped(String apellido) {
		//Parte nueva por aprender
		//QUERY TIPED
		//SELECT e FROM
		TypedQuery<Estudiante> myQuery = this.entityManager.createQuery("SELECT e FROM Estudiante e WHERE e.apellido= :datoApellido", Estudiante.class);
		myQuery.setParameter("datoApellido", apellido);
		return myQuery.getSingleResult();
	}

	@Override
	public Estudiante seleccionarPorApellidoNamed(String apellido) {
		TypedQuery<Estudiante> myQuery=this.entityManager.createNamedQuery("Estudiante.buscaPorApellido", Estudiante.class);
		
		myQuery.setParameter("datoApellido", apellido);
		return myQuery.getSingleResult();
	}

	@Override
	public Estudiante seleccionarPorApellidoNamedQuery(String apellido) {
		Query myQuery=this.entityManager.createNamedQuery("Estudiante.buscaPorApellido", Estudiante.class);
		myQuery.setParameter("datoApellido", apellido);
		return (Estudiante) myQuery.getSingleResult();
	}

	//NATIVE QUERY
	@Override
	public Estudiante seleccionarPorApellidoNativeQuery(String apellido) {
		Query myQuery = this.entityManager.createNativeQuery("SELECT * FROM estudiante where estu_apellido = :datoApellido", Estudiante.class);
		myQuery.setParameter("datoApellido", apellido);
		return (Estudiante) myQuery.getSingleResult();
	}

	@Override
	public Estudiante seleccionarPorApellidoTypedNativeQuery(String apellido) {
		TypedQuery<Estudiante> myQuery = this.entityManager.createNamedQuery("Estudiante.buscarApellidoNative", Estudiante.class);
		myQuery.setParameter("datoApellido", apellido);
		return myQuery.getSingleResult();
	}

	
	@Override
	public Estudiante seleccionarPorNombreNamedQuery(String nombre) {
		Query myQuery=this.entityManager.createNamedQuery("Estudiante.buscaPorNombre", Estudiante.class);
		myQuery.setParameter("datoNombre", nombre);
		return (Estudiante) myQuery.getSingleResult();
	}

	@Override
	public Estudiante seleccionarPorNombreTypedNativeQuery(String nombre) {
		TypedQuery<Estudiante> myQuery = this.entityManager.createNamedQuery("Estudiante.buscarNombreNative", Estudiante.class);
		myQuery.setParameter("datoNombre", nombre);
		return myQuery.getSingleResult();
	}

	@Override
	public Estudiante seleccionarPorApellidoCriteriaAPIQuery(String apellido) {
		CriteriaBuilder myBuilder = this.entityManager.getCriteriaBuilder();
		
		//1. Tipo de retorno que tiene mi Query
		CriteriaQuery<Estudiante>myCriteriaQuery= myBuilder.createQuery(Estudiante.class);
		
		//2. Empezamos  a crear el SQL
		//2.1 Definimos el from (Root)
		Root<Estudiante> myTablaFrom = myCriteriaQuery.from(Estudiante.class); //From Estudiante
		
		//3. Construir las condiciones de mi SQL 
		 //lAS CONDICIONES SE LAS CONOCE COMO PREDICADOS
		//CADA CONDICION ES UN PREDICADO
		//e.apellido = :datoApellido
		Predicate condicionApellido = myBuilder.equal(myTablaFrom.get("apellido"), apellido);
		
		//4. Armamos mi SQL final
		myCriteriaQuery.select(myTablaFrom).where(condicionApellido);
		
		//5. Laejecución del Query la realizamos con TypedQuery
		TypedQuery<Estudiante> myQueryFinal =this.entityManager.createQuery(myCriteriaQuery);
		
		return myQueryFinal.getSingleResult();
	}


	


}
