package P07_1984.models.institutions;

import P07_1984.models.Mediator;
import P07_1984.models.entities.Entity;

import java.util.ArrayList;
import java.util.List;

public class InstitutionImpl implements Institution {
	
	private Mediator mediator;
	
	private String id;
	
	private String name;
	
	private List<String> fieldNamesToMonitor;
	
	private List<Entity> entities;
	
	private List<String> entityChangeLogs;
	
	
	public InstitutionImpl( Mediator mediator,String id, String name, List<String> fieldNamesToMonitor) {
		this.mediator = mediator;
		this.id = id;
		this.name = name;
		this.fieldNamesToMonitor = fieldNamesToMonitor;
		this.entities = new ArrayList<>();
		this.entityChangeLogs = new ArrayList<>();
		this.mediator.addInstitution(this);
	}
	
	@Override
	public void setEntities(List<Entity> entities) {
		this.entities = entities;
	}
	
	@Override
	public String getId() {
		return id;
	}
	
	@Override
	public String getName() {
		return name;
	}
	
	@Override
	public List<String> getFieldNamesToMonitor() {
		return fieldNamesToMonitor;
	}
	
	@Override
	public void addEntityChangeLog(String line){
		this.entityChangeLogs.add(line);
	}
	
	
	private String getEntityChangeLogs(){
		return String.join(System.lineSeparator(), this.entityChangeLogs);
	}
	
	@Override
	public String toString() {
		StringBuilder result = new StringBuilder();
		result
				.append(String.format("%s: %d changes registered",this.getName(),this.entityChangeLogs.size()))
				.append(System.lineSeparator())
				.append(this.getEntityChangeLogs());
		
		return result.toString();
	}
}
