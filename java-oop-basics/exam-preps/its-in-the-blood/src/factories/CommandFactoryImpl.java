package factories;

import commands.commandimpl.*;
import commands.Command;
import commands.CommandType;
import repositories.Repository;

public class CommandFactoryImpl implements CommandFactory {
	
	private Repository organismRepository;
	
	public CommandFactoryImpl(Repository organismRepository) {
		this.organismRepository = organismRepository;
	}
	
	@Override
	public Command createCommand(String[] args) {
		CommandTypeFactory commandTypeFactory = new CommandTypeFactoryImpl();
		Command command = null;
		CommandType commandType;
		try {
			commandType = commandTypeFactory.createCommandType(args[0]);
			
			switch (commandType) {
				case CHECK_CONDITION:
					if (args.length == 2) {
						command = new CheckConditionCommand(organismRepository);
					}
					break;
				case CREATE_ORGANISM:
					if (args.length == 2) {
						command = new CreateOrganismCommand(organismRepository);
					}
					break;
				case ADD_CLUSTER:
					if (args.length == 5) {
						command = new AddClusterCommand(organismRepository);
					}
					break;
				case ADD_CELL:
					if (args.length == 9) {
						command = new AddCellCommand(organismRepository);
					}
					break;
				case ACTIVATE_CLUSTER:
					if (args.length == 2) {
						command = new ActivateClusterCommand(organismRepository);
					}
					break;
			}
		} catch (Exception e) {
			return null;
		}
		return command;
	}
}
