package com.linkedin.learning.otrareunionmas.dao;

import java.util.List;
import java.util.Optional;

/**
 * Como vamos a tratar distintos tipos de datos, entidades, la hacemos paremetizable.
 * @param <T>
 */
public interface Dao<T> {
	Optional<T> get (long id);//Puede ser que no obtenga ninguno
	List<T> getAll();
	void save(T t);
	void update(T t);
	void delete(T t);
}
