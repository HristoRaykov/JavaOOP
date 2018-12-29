package factories;

import interfaces.Attack;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public final class AttackFactory {
	
	private static final String ATTACK_CLASS_PATH = "models.attacks.";
	@SuppressWarnings("unchecked")
	public static Attack create(String attackType) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
		Class<? extends Attack> attackClass = (Class<? extends Attack>) Class.forName(ATTACK_CLASS_PATH+attackType);
		Constructor<? extends Attack> constructor = attackClass.getDeclaredConstructor();
		
		return constructor.newInstance();
	}
}
