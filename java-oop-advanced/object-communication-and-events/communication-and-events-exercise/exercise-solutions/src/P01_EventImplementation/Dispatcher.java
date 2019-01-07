package P01_EventImplementation;

import java.util.ArrayList;
import java.util.List;

public class Dispatcher {
	
	private String name;
	
	private List<NameChangeListener> nameChangeListeners;
	
	public Dispatcher() {
		nameChangeListeners = new ArrayList<>();
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void addNameChangeListeners(NameChangeListener nameChangeListener){
		this.nameChangeListeners.add(nameChangeListener);
	}
	
	public void removeNameChangeListener(NameChangeListener nameChangeListener){
		this.nameChangeListeners.remove(nameChangeListener);
	}
	
	public void fireNameChangeEvent(){
		for (NameChangeListener nameChangeListener : nameChangeListeners) {
			nameChangeListener.handleChangedName(new EventNameChange(this.getName()));
		}
	}
}
