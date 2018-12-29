package interfaces;

import java.util.Collection;

public interface Repository<T> {
	
	void add(T entity);
	
	T findByName(String name);
	
	Collection<T> findAll();
	
}
