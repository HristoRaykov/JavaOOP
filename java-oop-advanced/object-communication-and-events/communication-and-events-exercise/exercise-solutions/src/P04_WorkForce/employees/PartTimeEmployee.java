package P04_WorkForce.employees;

import P04_WorkForce.mediator.Mediator;

public class PartTimeEmployee extends BaseEmployee {
	
	private static final int WORK_HOURS_PER_WEEK = 20;
	
	public PartTimeEmployee(Mediator mediator, String name) {
		super(mediator, name);
		super.setWorkHoursPerWeek(WORK_HOURS_PER_WEEK);
	}
	
	
}
