package P04_WorkForce.employees;

import P04_WorkForce.mediator.Mediator;

public interface Employee {
	
	Mediator getMediator();
	
	String getName();
	
	int getWorkHoursPerWeek();
	
}
