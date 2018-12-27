package commands;

public enum CommandType {

	CHECK_CONDITION,
	CREATE_ORGANISM,
	ADD_CLUSTER,
	ADD_CELL,
	ACTIVATE_CLUSTER;
	
	
	@Override
	public String toString() {
		String[] splitted =  this.name().split("_");
		String firstWord = splitted[0].toLowerCase();
		String secondWord = splitted[1].substring(0,1).toUpperCase()+splitted[1].substring(1).toLowerCase();
		
		return firstWord+secondWord;
	}
}
