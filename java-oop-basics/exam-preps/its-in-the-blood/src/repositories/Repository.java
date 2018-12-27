package repositories;

public interface Repository<T> {

	String save(T entity);
	
	T findEntityByName(String name);

}
