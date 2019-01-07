package P04_WorkForce.employees;

import P04_WorkForce.mediator.Mediator;

public class StandartEmployee extends BaseEmployee {
	
	private static final int WORK_HOURS_PER_WEEK = 40;
	
	public StandartEmployee(Mediator mediator, String name) {
		super(mediator, name);
		super.setWorkHoursPerWeek(WORK_HOURS_PER_WEEK);
	}
	
}
