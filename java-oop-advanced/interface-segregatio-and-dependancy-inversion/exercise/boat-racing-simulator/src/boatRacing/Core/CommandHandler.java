package boatRacing.Core;

import boatRacing.exeptions.*;

import java.util.List;

public interface CommandHandler {
 
	String ExecuteCommand(String name, List<String> parameters) throws DuplicateModelException, NonExistantModelException, RaceAlreadyExistsException, NoSetRaceException, InsufficientContestantsException;
	
}
