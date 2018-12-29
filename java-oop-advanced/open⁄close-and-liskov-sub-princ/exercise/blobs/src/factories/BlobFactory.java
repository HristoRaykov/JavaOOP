package factories;

import interfaces.Attack;
import interfaces.Behavior;
import models.Blob;

public final class BlobFactory {

	public static Blob create(String name, int health, int damage, Behavior behavior, Attack attack,boolean flag){
		return new Blob(name, health, damage, behavior, attack,flag);
	}
	

}
