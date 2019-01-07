package P07_1984.models.entities;


import P07_1984.models.Mediator;

import java.lang.reflect.InvocationTargetException;

public class Company extends BaseEntity{
	
	private int turnover;
	
	private int revenue;
	
	public Company(Mediator mediator, String id, String name, int turnover, int revenue) {
		super(mediator, id, name);
		this.turnover = turnover;
		this.revenue = revenue;
	}
	
	public int getTurnover() {
		return turnover;
	}
	
	public void setTurnover(int turnover) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
		super.getMediator().registerChange(this,"turnover",String.valueOf(turnover));
		this.turnover = turnover;
	}
	
	public int getRevenue() {
		return revenue;
	}
	
	public void setRevenue(int revenue) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
		super.getMediator().registerChange(this,"revenue",String.valueOf(revenue));
		this.revenue = revenue;
	}
}
