package P04_WorkForce.employees;

import P04_WorkForce.mediator.Mediator;

public abstract class BaseEmployee implements Employee{
	
	private Mediator mediator;
	
	private String name;
	
	private int workHoursPerWeek;
	
	BaseEmployee(Mediator mediator, String name) {
		this.mediator = mediator;
		this.name = name;
		this.getMediator().addEmployee(this);
	}
	
	@Override
	public Mediator getMediator() {
		return mediator;
	}
	
	@Override
	public String getName() {
		return name;
	}
	
	@Override
	public int getWorkHoursPerWeek() {
		return workHoursPerWeek;
	}
	
	void setWorkHoursPerWeek(int workHoursPerWeek) {
		this.workHoursPerWeek = workHoursPerWeek;
	}
	
}
