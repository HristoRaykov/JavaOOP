package core.commands;

import annotations.Inject;
import interfaces.Executable;
import interfaces.Repository;
import models.Blob;

import java.lang.reflect.InvocationTargetException;

public class AttackCommand implements Executable{
	
	@Inject
	private Repository<Blob> repository;
	
	@Inject
	private String[] params;
	
	
	@Override
	public void execute() throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
		Blob attacker = this.repository.findByName(this.params[1]);
		Blob target = this.repository.findByName(this.params[2]);
		
		attacker.attack(target);
		
	}
	
	
}
