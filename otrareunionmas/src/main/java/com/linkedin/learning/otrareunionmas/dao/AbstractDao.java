package com.linkedin.learning.otrareunionmas.dao;

import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;

import com.linkedin.learning.otrareunionmas.utiles.EntityManagerUtil;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Query;

public abstract class AbstractDao<T> implements Dao<T> {
	
	private EntityManager entityManager = EntityManagerUtil.getEntityManager();
	
	private Class<T> clazz;

	@Override
	public Optional<T> get(long id) {
		return Optional.ofNullable(entityManager.find(clazz, id)); //Utilizamos el nullable para asegurarnos de que se maneja bien, en caso de que no encuentre nada.
	}

	@Override
	public List<T> getAll() {
		String qlString = "FROM" + clazz.getName();
		Query query = entityManager.createQuery(qlString);
		return query.getResultList();
	}

	@Override
	public void save(T t) {
		executeInsideTransaction(entityManager -> entityManager.persist(t));
	}

	@Override
	public void update(T t) {
		executeInsideTransaction(entityManager -> entityManager.merge(t));
		
	}

	@Override
	public void delete(T t) {
		executeInsideTransaction(entityManager -> entityManager.remove(t) );
	}

	public void setClazz(Class<T> clazz) {
		this.clazz = clazz;
	}
	/**
	 * Para los métodos de modificación (Guardar, actualizar o borrar).
	 * Como modifican la base de datos, deberíamos ser capaces de deshacer si hay algún problema
	 * También tenemos que indicar cuando empezamos y terminamos la transacción
	 * Como esto va a ser lo mismo para cualquiera de las tres operaciones, lo dejamos en un método privado.
	 * @param action
	 */
	private void executeInsideTransaction(Consumer<EntityManager> action) {
		//Pedimos una transacción al EntityManager
		EntityTransaction tx = entityManager.getTransaction();
		try {
			//Intentamos inicializarla
			tx.begin();
			//Ejecutamos la acción de turno
			action.accept(entityManager);
			//Comiteamos la transacción
			tx.commit();
		}catch(RuntimeException e) {
			//Si hay algún problema, deshacemos
			tx.rollback();
			//Lanzamos una excepción
			throw e;
		}
	}
	
}
