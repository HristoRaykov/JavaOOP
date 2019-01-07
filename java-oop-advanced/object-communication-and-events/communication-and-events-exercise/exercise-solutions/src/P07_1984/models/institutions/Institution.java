package P07_1984.models.institutions;

import P07_1984.models.entities.Entity;

import java.util.List;

public interface Institution {
	
	void setEntities(List<Entity> entities);
	
	String getId();
	
	String getName();
	
	List<String> getFieldNamesToMonitor();
	
	void addEntityChangeLog(String line);
}
