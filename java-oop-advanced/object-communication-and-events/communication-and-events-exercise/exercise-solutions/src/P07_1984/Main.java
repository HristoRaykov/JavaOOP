package P07_1984;


import P07_1984.models.Mediator;
import P07_1984.models.MediatorImpl;
import P07_1984.models.entities.Company;
import P07_1984.models.entities.Employee;
import P07_1984.models.entities.Entity;
import P07_1984.models.institutions.Institution;
import P07_1984.models.institutions.InstitutionImpl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
	
	public static void main(String[] args) throws IOException, NoSuchMethodException, InvocationTargetException, IllegalAccessException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		Mediator mediator = new MediatorImpl();
		
		String line = reader.readLine();
		List<String> params = Arrays.stream(line.split("\\s+")).collect(Collectors.toList());
		int numberOfEntities = Integer.valueOf(params.get(0));
		int numberOfInstitutions = Integer.valueOf(params.get(1));
		int numberOfChanges = Integer.valueOf(params.get(2));
		
		for (int i = 0; i < numberOfEntities; i++) {
			line = reader.readLine();
			params = Arrays.stream(line.split("\\s+")).collect(Collectors.toList());
			
			switch (params.get(0)) {
				case "Employee":
					Entity employee = new Employee(mediator, params.get(1), params.get(2),
							Integer.parseInt(params.get(3)));
					break;
				case "Company":
					Entity companyEntity = new Company(mediator, params.get(1), params.get(2)
							, Integer.parseInt(params.get(3)),
							Integer.parseInt(params.get(4)));
					break;
					
			}
		}
		
		for (int i = 0; i < numberOfInstitutions; i++) {
			line = reader.readLine();
			params = Arrays.stream(line.split("\\s+")).collect(Collectors.toList());
			Institution institution = new InstitutionImpl(mediator, params.get(1), params.get(2),
					params.stream().skip(3).collect(Collectors.toList()));
			
		}
		
		for (int i = 0; i < numberOfChanges ; i++) {
			line = reader.readLine();
			params = Arrays.stream(line.split("\\s+")).collect(Collectors.toList());
			Entity entity = mediator.getEntityById(params.get(0));
			String methodName = "set"+Character.toUpperCase(params.get(1).charAt(0))+params.get(1).substring(1);
			Class<? extends Entity> entityClass = entity.getClass();
			Method method;
			try {
				int value = Integer.parseInt(params.get(2));
				method = entityClass.getMethod(methodName,int.class);
				method.invoke(entity,value);
			}catch (Exception e){
				method = entityClass.getMethod(methodName,String.class);
				method.invoke(entity,params.get(2));
			}
		}

		System.out.println(mediator);
		
	}
	
}
