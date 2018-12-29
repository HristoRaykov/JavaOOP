package factories;

import interfaces.Behavior;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public final class BehaviorFactory {
	
	private static final String BEHAVIOR_CLASS_PATH = "models.behaviors.";
	
	@SuppressWarnings("unchecked")
	public static Behavior create(String name) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
		Class<? extends Behavior> behaviorClass = (Class<? extends Behavior>) Class.forName(BEHAVIOR_CLASS_PATH+name);
		
		Constructor<? extends Behavior> constructor = behaviorClass.getDeclaredConstructor();
		
		return constructor.newInstance();
	}
}
