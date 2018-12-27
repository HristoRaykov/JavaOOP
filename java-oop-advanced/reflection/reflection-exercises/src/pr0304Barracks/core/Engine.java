package pr0304Barracks.core;

import jdk.jshell.spi.ExecutionControl;
import pr0304Barracks.contracts.Runnable;
import pr0304Barracks.contracts.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;

public class Engine implements Runnable {
	
	private Repository repository;
	private UnitFactory unitFactory;
	
	
	public Engine(Repository repository, UnitFactory unitFactory) {
		this.repository = repository;
		this.unitFactory = unitFactory;
	}
	
	@Override
	public void run() {
		BufferedReader reader = new BufferedReader(
				new InputStreamReader(System.in));
		while (true) {
			try {
				String input = reader.readLine();
				String[] data = input.split("\\s+");
				String commandName = data[0];
				String result = interpredCommand(data, commandName);
				if (result.equals("fight")) {
					break;
				}
				System.out.println(result);
			} catch (RuntimeException e) {
				System.out.println(e.getMessage());
			} catch (IOException | ExecutionControl.NotImplementedException | NoSuchMethodException | ClassNotFoundException | IllegalAccessException | InstantiationException | InvocationTargetException e) {
				e.printStackTrace();
			}
		}
	}
	
	
	private String interpredCommand(String[] data, String commandName) throws ExecutionControl.NotImplementedException, NoSuchMethodException, ClassNotFoundException, IllegalAccessException, InvocationTargetException, InstantiationException {
		
		
		String commandClassName = "pr0304Barracks.core.commands." + Character.toUpperCase(commandName.charAt(0)) + commandName.substring(1) + "Command";
		Class<?> commandClass = Class.forName(commandClassName);
		Constructor<?> constructor = commandClass
				.getDeclaredConstructor();
		constructor.setAccessible(true);
		Executable command = (Executable) constructor.newInstance();
		this.injectDependancies(command, data);
		
		
		return command.execute();
	}
	
	private <T extends Executable> void injectDependancies(T command, String[] data) throws IllegalAccessException {
		Field[] commandFields = command.getClass().getDeclaredFields();
		Field[] engineFields = Engine.class.getDeclaredFields();
		
		for (Field commandField : commandFields) {
			commandField.setAccessible(true);
			if (commandField.getType().getSimpleName().equals(String[].class.getSimpleName())){
				commandField.set(command, data);
				continue;
			}
			Field engineField = Arrays.stream(engineFields)
					.filter(f -> f.getType().getSimpleName().equals(commandField.getType().getSimpleName()))
					.findFirst()
					.orElse(null);
			engineField.setAccessible(true);
			
			commandField.set(command, engineField.get(this));
			
			
		}
		
	}
	
	
}
