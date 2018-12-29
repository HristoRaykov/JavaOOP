package core.commands;

import annotations.Inject;
import interfaces.Executable;
import utils.ReportEventFlag;

import java.lang.reflect.InvocationTargetException;

public class ReportEventsCommand implements Executable {
	
	@Inject
	private ReportEventFlag reportEventFlag;
	
	@Override
	public void execute() throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
		reportEventFlag.setFlag(true);
	}
}
