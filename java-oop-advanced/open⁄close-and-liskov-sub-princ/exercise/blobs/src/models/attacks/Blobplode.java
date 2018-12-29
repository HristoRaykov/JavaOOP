package models.attacks;

import interfaces.Attack;
import models.Blob;

public class Blobplode implements Attack {
	
	@Override
	public void execute(Blob source, Blob target) {
		int halfHealth = source.getCurrentHealth()%2==0 ? source.getCurrentHealth()/2 :source.getCurrentHealth()/2+1;
		if (halfHealth<1){
			halfHealth = 1;
		}
		source.setCurrentHealth(halfHealth);
		target.setCurrentHealth(target.getCurrentHealth()-source.getDamage()*2);
	}
}
