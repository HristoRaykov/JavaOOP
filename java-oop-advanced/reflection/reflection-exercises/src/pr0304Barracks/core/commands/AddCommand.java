package pr0304Barracks.core.commands;

import jdk.jshell.spi.ExecutionControl;
import pr0304Barracks.contracts.Executable;
import pr0304Barracks.contracts.Repository;
import pr0304Barracks.contracts.Unit;
import pr0304Barracks.contracts.UnitFactory;

import java.lang.reflect.InvocationTargetException;

public class AddCommand implements Executable {
	
	private String[] data;
	
	private Repository repository;
	
	private UnitFactory unitFactory;
	
	
	@Override
	public String execute() throws NoSuchMethodException, IllegalAccessException, InstantiationException, ExecutionControl.NotImplementedException, InvocationTargetException, ClassNotFoundException {
		String unitType = data[1];
		Unit unitToAdd = unitFactory.createUnit(unitType);
		repository.addUnit(unitToAdd);
		return unitType + " added!";
	}
}
