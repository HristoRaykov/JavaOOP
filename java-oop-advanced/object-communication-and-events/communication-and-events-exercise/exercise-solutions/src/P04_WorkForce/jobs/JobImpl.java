package P04_WorkForce.jobs;

import P04_WorkForce.employees.Employee;
import P04_WorkForce.mediator.Mediator;

public class JobImpl implements Job {
	
	private Mediator mediator;
	
	private Employee employee;
	
	private String name;
	
	private int hoursOfWorkRequired;
	
	private boolean isJobDone;
	
	
	public JobImpl(Mediator mediator, String name, int hoursOfWorkRequired, String employeeName) {
		this.mediator = mediator;
		this.name = name;
		this.hoursOfWorkRequired = hoursOfWorkRequired;
		this.employee = this.getMediator().getEmployeeByName(employeeName);
		this.getMediator().addJob(this);
		this.isJobDone = false;
	}
	
	@Override
	public boolean isJobDone() {
		return isJobDone;
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
	public int getHoursOfWorkRequired() {
		return hoursOfWorkRequired;
	}
	
	@Override
	public void update() {
		this.hoursOfWorkRequired -= this.employee.getWorkHoursPerWeek();
		
		if (this.getHoursOfWorkRequired()<=0) {
			System.out.println(this);
			this.getMediator().addJobForDeletion(this.getName());
		}
	}
	
	@Override
	public String toString() {
		if (this.getHoursOfWorkRequired() <= 0) {
			return String.format("Job %s done!", this.getName());
		}
		
		return String.format("Job: %s Hours Remaining: %s", this.getName(), this.getHoursOfWorkRequired());
	}
}
