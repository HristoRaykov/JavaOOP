package P04_WorkForce.mediator;

import P04_WorkForce.employees.Employee;
import P04_WorkForce.jobs.Job;

import java.util.*;

public class MediatorImpl implements Mediator {
	
	private Map<String,Employee> employees;
	
	private Map<String, Job> jobs;
	
	private List<String> deletedJobs;
	
	
	public MediatorImpl() {
		this.employees = new LinkedHashMap<>();
		this.jobs = new LinkedHashMap<>();
		this.deletedJobs = new ArrayList<>();
	}
	
	
	@Override
	public void addJobForDeletion(String jobName){
		this.deletedJobs.add(jobName);
	}
	
	@Override
	public void addEmployee(Employee employee){
		this.employees.putIfAbsent(employee.getName(),employee);
	}
	
	@Override
	public Employee getEmployeeByName(String employeeName){
		return this.employees.get(employeeName);
	}
	
	@Override
	public void addJob(Job job){
		this.jobs.putIfAbsent(job.getName(),job);
	}
	
	@Override
	public void updateAllJobs(){
		for (Job job : jobs.values()) {
			job.update();
		}
		deleteJobs();
	}
	
	@Override
	public void deleteJobs() {
		for (String deletedJob : deletedJobs) {
			this.jobs.remove(deletedJob);
		}
		this.deletedJobs.clear();
	}
	
	@Override
	public void printJobsStatus(){
		for (Job job : jobs.values()) {
			System.out.println(job);
		}
	}
	
	
}
