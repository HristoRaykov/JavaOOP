package core.commands;

import annotations.Inject;
import factories.AttackFactory;
import factories.BehaviorFactory;
import factories.BlobFactory;
import interfaces.Attack;
import interfaces.Behavior;
import interfaces.Executable;
import interfaces.Repository;
import models.Blob;
import observers.Subject;
import utils.ReportEventFlag;


import java.lang.reflect.InvocationTargetException;

public class CreateCommand implements Executable{
	
	@Inject
	private Repository<Blob> repository;
	@Inject
	private String[] params;
	@Inject
	private Subject subject;
	@Inject
	private ReportEventFlag reportEventFlag;
	
	@Override
	public void execute() throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
		Behavior behavior = BehaviorFactory.create(params[4]);
		Attack attack = AttackFactory.create(params[5]);
		
		Blob blob = BlobFactory.create(params[1],
				Integer.parseInt(params[2]),
				Integer.parseInt(params[3]),
				behavior,
				attack,
				reportEventFlag.getFlag());
		
		repository.add(blob);
		this.subject.addObserver(blob);
	}
}
