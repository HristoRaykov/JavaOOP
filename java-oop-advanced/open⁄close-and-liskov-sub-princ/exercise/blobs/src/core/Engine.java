package core;

import annotations.Inject;
import interfaces.Runnable;
import interfaces.*;
import models.Blob;
import observers.Subject;
import utils.ReportEventFlag;

import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.stream.Collectors;

public class Engine implements Runnable {
	
	private static final String COMMAND_CLASS_PATH = "core.commands.";
	private static final String COMMAND_SUFFIX = "Command";
	
	private String[] params;
	private final Reader reader;
	private final Writer writer;
	private final Repository<Blob> repository;
	private Subject subject;
	private ReportEventFlag reportEventFlag;
	
	public Engine(Reader reader, Writer writer, Repository<Blob> repository, Subject subject, ReportEventFlag reportEventFlag) {
		this.reader = reader;
		this.writer = writer;
		this.repository = repository;
		this.subject = subject;
		this.reportEventFlag = reportEventFlag;
	}
	
	@Override
	public void run() {
		while (true) {
			try {
				String line = reader.readLine();
				if ("drop".equals(line)) {
					break;
				}
				params = line.split("\\s+");
				
				this.interpredCommand(params);
				
			} catch (RuntimeException | IOException e) {
				writer.writeLine(e.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unchecked")
	private void interpredCommand(String[] params) throws RuntimeException {
		try {
			String commandName = getCommandName(params[0]);
			Class<? extends Executable> commandClass =
					(Class<? extends Executable>) Class.forName(COMMAND_CLASS_PATH + commandName + COMMAND_SUFFIX);
			Executable command = commandClass.getDeclaredConstructor().newInstance();
			
			this.injectDependencies(command);
			
			command.execute();
			
		} catch (ClassNotFoundException |
				InstantiationException |
				IllegalAccessException |
				InvocationTargetException |
				IndexOutOfBoundsException |
				NoSuchMethodException e) {
			throw new RuntimeException("Invalid command!");
		}
		
		subject.notifyAllObservers();
	}
	
	private String getCommandName(String name) {
		
		if (name.contains("-")){
			return Arrays.stream(name.split("-"))
					.map(word -> Character.toUpperCase(word.charAt(0)) + word.substring(1))
					.collect(Collectors.joining(""));
		}
		
		return Character.toUpperCase(name.charAt(0)) + name.substring(1);
	}
	
	private void injectDependencies(Executable command) throws IllegalAccessException {
		Field[] commandFields = Arrays.stream(command.getClass()
				.getDeclaredFields())
				.filter(field -> field.isAnnotationPresent(Inject.class))
				.toArray(Field[]::new);
		Field[] engineFields = this.getClass().getDeclaredFields();
		
		for (Field commandField : commandFields) {
			for (Field engineField : engineFields) {
				commandField.setAccessible(true);
				engineField.setAccessible(true);
				if (engineField.getType().getSimpleName().equals(commandField.getType().getSimpleName())) {
					commandField.set(command, engineField.get(this));
				}
			}
			
		}
		
	}
	
	
}
