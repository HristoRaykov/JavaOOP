package core.commands;

import annotations.Inject;
import interfaces.Executable;
import interfaces.Repository;
import interfaces.Writer;
import models.Blob;

import java.lang.reflect.InvocationTargetException;

public class StatusCommand implements Executable {
	
	@Inject
	private Repository<Blob> repository;
	
	@Inject
	private Writer writer;
	
	@Override
	public void execute() throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
		this.repository.findAll().forEach(blob -> writer.writeLine(blob.toString()));
		
	}
}
