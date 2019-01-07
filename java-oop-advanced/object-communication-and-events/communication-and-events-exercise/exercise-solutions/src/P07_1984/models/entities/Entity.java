package P07_1984.models.entities;

import java.lang.reflect.InvocationTargetException;

public interface Entity {
	
	
	String getId();
	
	String getName();
	
	void setName(String name) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException;
}
