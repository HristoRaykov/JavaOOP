package P07_1984.models;

import P07_1984.models.entities.Entity;
import P07_1984.models.institutions.Institution;

import java.lang.reflect.InvocationTargetException;

public interface Mediator {
	
	
	Entity getEntityById(String id);
	
	void addEntity(Entity entity);
	
	void addInstitution(Institution institution);
	
	void registerChange(Entity entity, String fieldName, String fieldValue) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException;
}
