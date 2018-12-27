package factories;

import commands.CommandType;

public class CommandTypeFactoryImpl implements CommandTypeFactory {
	
	@Override
	public CommandType createCommandType(String name) {
		CommandType commandType = null;
		switch (name) {
			case "checkCondition":
				commandType = CommandType.CHECK_CONDITION;
			break;
			case "createOrganism":
				commandType =  CommandType.CREATE_ORGANISM;
			break;
			case "addCluster":
				commandType =  CommandType.ADD_CLUSTER;
				break;
			case "addCell":
				commandType =  CommandType.ADD_CELL;
				break;
			case "activateCluster":
				commandType =  CommandType.ACTIVATE_CLUSTER;
				break;
			
		}
		
		return commandType;
	}
}
