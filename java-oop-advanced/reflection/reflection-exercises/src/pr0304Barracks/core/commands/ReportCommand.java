package pr0304Barracks.core.commands;

import jdk.jshell.spi.ExecutionControl;
import pr0304Barracks.contracts.Executable;
import pr0304Barracks.contracts.Repository;

import java.lang.reflect.InvocationTargetException;

public class ReportCommand implements Executable {
	
	private Repository repository;
	
	private String[] data;
	
	@Override
	public String execute() throws NoSuchMethodException, IllegalAccessException, InstantiationException, ExecutionControl.NotImplementedException, InvocationTargetException, ClassNotFoundException {
		return repository.getStatistics();
	}
}
