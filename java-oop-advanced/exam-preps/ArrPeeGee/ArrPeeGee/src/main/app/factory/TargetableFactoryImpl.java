package factory;

import contracts.Targetable;
import contracts.TargetableFactory;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;


public class TargetableFactoryImpl implements TargetableFactory {
	
	
	private static final String PACKAGE_PATH = "models.participants.";
	
	@Override
	public Targetable create(String name, String className) throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException, InvocationTargetException {
		
		Class<? extends Targetable> targetableClass = (Class<? extends Targetable>) Class.forName(PACKAGE_PATH + className);
		
		Constructor<? extends Targetable> constructor = targetableClass.getDeclaredConstructor(String.class);
		constructor.setAccessible(true);
		return constructor.newInstance(name);
	}
	
	
}
