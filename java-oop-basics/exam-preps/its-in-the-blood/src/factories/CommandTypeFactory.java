package factories;

import commands.CommandType;

public interface CommandTypeFactory {
	
	CommandType createCommandType(String name);
}
