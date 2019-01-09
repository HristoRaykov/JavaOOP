package factory;

import contracts.Action;
import contracts.ActionFactory;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class ActionFactoryImpl implements ActionFactory {
	
	private static final String PACKAGE_PATH = "models.actions.";
	
	@Override
	public Action create(String actionName, String... participantNames) throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
		
		Class<? extends Action> actionClass = (Class<? extends Action>) Class.forName(PACKAGE_PATH +actionName);
		Constructor<? extends Action> constructor = actionClass.getDeclaredConstructor();
		constructor.setAccessible(true);
		return constructor.newInstance();
	}
	
	
}
