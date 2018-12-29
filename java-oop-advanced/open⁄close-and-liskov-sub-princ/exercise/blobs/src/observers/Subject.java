package observers;

import java.util.ArrayList;
import java.util.List;

public class Subject {
	
	private List<Observer> observers;
	
	public Subject() {
		this.observers = new ArrayList<>();
	}
	
	public void addObserver(Observer observer){
		observers.add(observer);
	}
	
	public void notifyAllObservers(){
		observers.forEach(Observer::update);
	}
	
	
}
