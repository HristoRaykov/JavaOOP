package pr0304Barracks.core.commands;

import jdk.jshell.spi.ExecutionControl;
import pr0304Barracks.contracts.Executable;

import java.lang.reflect.InvocationTargetException;

public class FightCommand implements Executable {
	
	
	@Override
	public String execute() throws NoSuchMethodException, IllegalAccessException, InstantiationException, ExecutionControl.NotImplementedException, InvocationTargetException, ClassNotFoundException {
		return "fight";
	}
}
