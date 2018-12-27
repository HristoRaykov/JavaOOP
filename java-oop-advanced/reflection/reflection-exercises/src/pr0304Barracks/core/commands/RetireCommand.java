package pr0304Barracks.core.commands;

import jdk.jshell.spi.ExecutionControl;
import pr0304Barracks.contracts.Executable;
import pr0304Barracks.contracts.Repository;

import java.lang.reflect.InvocationTargetException;

public class RetireCommand implements Executable {
	
	private Repository repository;
	
	private String[] data;
	
	@Override
	public String execute() throws NoSuchMethodException, IllegalAccessException, InstantiationException, InvocationTargetException, ClassNotFoundException {
		String unitType = data[1];
		try {
			repository.removeUnit(unitType);
			
		} catch (ExecutionControl.NotImplementedException e) {
			return e.getMessage();
		}
		
		return unitType + " retired!";
	}
}
