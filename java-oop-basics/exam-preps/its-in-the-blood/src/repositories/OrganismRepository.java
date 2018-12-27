package repositories;

import entities.Organism;

import java.util.HashMap;
import java.util.Map;

public class OrganismRepository implements Repository<Organism> {
	
	private Map<String, Organism> organismDB;
	
	public OrganismRepository() {
		organismDB=new HashMap<>();
	}
	
	@Override
	public String save(Organism entity) {
		if (organismDB.containsKey(entity.getName())){
			return String.format("Organism %s already exists",entity.getName());
		}
		
		organismDB.put(entity.getName(),entity);
		return String.format("Created organism %s",entity.getName());
	}
	
	@Override
	public Organism findEntityByName(String name) {
		return organismDB.get(name);
	}
}
