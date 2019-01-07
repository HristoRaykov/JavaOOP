package P04_WorkForce;

import P04_WorkForce.employees.Employee;
import P04_WorkForce.employees.PartTimeEmployee;
import P04_WorkForce.employees.StandartEmployee;
import P04_WorkForce.jobs.Job;
import P04_WorkForce.jobs.JobImpl;
import P04_WorkForce.mediator.Mediator;
import P04_WorkForce.mediator.MediatorImpl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		Mediator mediator = new MediatorImpl();
		
		String line;
		String[] params;
		while (!"End".equals(line=reader.readLine())){
			params = line.split("\\s+");
			
			switch (params[0]){
				case "StandartEmployee":
					Employee standartEmployee = new StandartEmployee(mediator,params[1].trim());
					break;
				case "PartTimeEmployee":
					Employee partTimeEmployee = new PartTimeEmployee(mediator,params[1].trim());
					break;
				case "Job":
					Job job = new JobImpl(mediator,params[1],Integer.valueOf(params[2]),params[3]);
					break;
				case "Pass":
					mediator.updateAllJobs();
					mediator.deleteJobs();
					break;
				case "Status":
					mediator.printJobsStatus();
					break;
				
			}
			
			
		}
		
	
	}
	
	
}
