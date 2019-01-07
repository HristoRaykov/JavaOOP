package P02_KingsGambit.models;

public abstract class BaseUnit {
	
	private String name;
	
	public BaseUnit(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
}
