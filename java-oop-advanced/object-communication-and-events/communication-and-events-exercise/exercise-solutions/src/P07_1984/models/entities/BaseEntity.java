package P07_1984.models.entities;


import P07_1984.models.Mediator;

import java.lang.reflect.InvocationTargetException;

public abstract class BaseEntity implements Entity {
	
	private Mediator mediator;
	
	private String id;
	
	private String name;
	
	public BaseEntity(Mediator mediator, String id, String name) {
		this.mediator = mediator;
		this.id = id;
		this.name = name;
		this.mediator.addEntity(this);
	}
	
	protected Mediator getMediator() {
		return mediator;
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
	public void setName(String name) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
		this.mediator.registerChange(this,"name",name);
		this.name = name;
	}
	
	@Override
	public String toString() {
		return String.format("%s(ID:%s)",this.getClass().getSimpleName(),this.getId());
	}
}
