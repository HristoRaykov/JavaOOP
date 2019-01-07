package P04_WorkForce.mediator;

import P04_WorkForce.employees.Employee;
import P04_WorkForce.jobs.Job;

public interface Mediator {
	
	void addJobForDeletion(String jobName);
	
	void addEmployee(Employee employee);
	
	Employee getEmployeeByName(String employeeName);
	
	void addJob(Job job);
	
	void updateAllJobs();
	
	void deleteJobs();
	
	void printJobsStatus();
	
	
}
