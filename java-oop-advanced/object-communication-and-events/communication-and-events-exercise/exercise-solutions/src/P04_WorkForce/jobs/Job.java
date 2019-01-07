package P04_WorkForce.jobs;

import P04_WorkForce.mediator.Mediator;

public interface Job {
	
	boolean isJobDone();
	
	Mediator getMediator();
	
	String getName();
	
	int getHoursOfWorkRequired();
	
	void update();
	
	


}
