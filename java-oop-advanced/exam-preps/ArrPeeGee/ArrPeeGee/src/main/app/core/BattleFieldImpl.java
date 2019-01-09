package core;

import contracts.*;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class BattleFieldImpl implements Battlefield {
	
	private Map<String, Targetable> participants;
	private List<Action> executedActions;
	private Writer writer;
	private TargetableFactory targetableFactory;
	private ActionFactory actionFactory;
	
	public BattleFieldImpl(Writer writer, TargetableFactory targetableFactory, ActionFactory actionFactory) {
		this.writer = writer;
		this.targetableFactory = targetableFactory;
		this.actionFactory = actionFactory;
		this.executedActions = new ArrayList<>();
		this.participants = new TreeMap<>();
	}
	
	private TargetableFactory getTargetableFactory() {
		return targetableFactory;
	}
	
	private ActionFactory getActionFactory() {
		return actionFactory;
	}
	
	
	@Override
	public void createAction(String actionName, String... participantNames) {
		List<Targetable> actionParticipants = new ArrayList<>();
		for (String name : participantNames) {
			if (this.participants.containsKey(name)) {
				actionParticipants.add(this.participants.get(name));
			} else {
				writer.writeLine(String.format("%s is not on the battlefield. %s failed.", name, actionName));
				return;
			}
		}
		
		try {
			Action action = this.getActionFactory().create(actionName);
			writer.writeLine(action.executeAction(actionParticipants));
			checkForDeadParticipants();
			this.executedActions.add(action);
		} catch (Exception e) {
			writer.writeLine("Action does not exist.");
		}
	}
	
	@Override
	public void createParticipant(String name, String className) {
		if (this.participants.containsKey(name)) {
			writer.writeLine("Participant with that name already exists.");
			return;
		}
		try {
			Targetable targetable = this.getTargetableFactory().create(name, className);
			
			this.participants.put(targetable.getName(), targetable);
			writer.writeLine(
					String.format("%s %s entered the battlefield.",
							targetable.getClass().getSimpleName(),
							targetable.getName()));
		} catch (ClassNotFoundException | IllegalAccessException | InstantiationException | NoSuchMethodException | InvocationTargetException e) {
			writer.writeLine("Participant class does not exist.");
		}
		
	}
	
	@Override
	public void createSpecial(String name, String specialName) {
		throw new UnsupportedOperationException();
	}
	
	@Override
	public void reportParticipants() {
		if (this.participants.size() < 1) {
			writer.writeLine("There are no participants on the battlefield.");
			return;
		}
		
		for (Targetable participant : this.participants.values()) {
			writer.writeLine(participant.toString());
			writer.writeLine("* * * * * * * * * * * * * * * * * * * *");
		}
	}
	
	@Override
	public void reportActions() {
		if (this.executedActions.size() < 1) {
			writer.writeLine("There are no actions on the battlefield.");
			return;
		}
		
		for (Action executedAction : executedActions) {
			writer.writeLine(executedAction.getClass().getSimpleName());
		}
	}
	
	private void checkForDeadParticipants() {
		Map<String, Targetable> aliveParticipants = new TreeMap<>();
		
		for (String name : this.participants.keySet()) {
			if (!this.participants.get(name).isAlive()) {
				writer.writeLine(String.format("%s has been removed from the battlefield.", name));
			} else {
				aliveParticipants.put(name, this.participants.get(name));
			}
		}
		
		this.participants = aliveParticipants;
	}
	
	
}
