package core.commands;

import annotations.Inject;
import interfaces.Executable;
import interfaces.Repository;
import models.Blob;

import java.lang.reflect.InvocationTargetException;

public class PassCommand implements Executable {
	
	@Inject
	private Repository<Blob> repository;
	
	@Override
	public void execute() throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
	
	}
}
