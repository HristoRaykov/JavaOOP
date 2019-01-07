package P07_1984.models.entities;


import P07_1984.models.Mediator;

import java.lang.reflect.InvocationTargetException;

public class Employee extends BaseEntity {
	
	private int income;
	
	public Employee(Mediator mediator, String id, String name, int income) {
		super(mediator, id, name);
		this.income = income;
	}
	
	public int getIncome() {
		return income;
	}
	
	public void setIncome(int income) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
		super.getMediator().registerChange(this,"income",String.valueOf(income));
		this.income = income;
	}
	
	
}
