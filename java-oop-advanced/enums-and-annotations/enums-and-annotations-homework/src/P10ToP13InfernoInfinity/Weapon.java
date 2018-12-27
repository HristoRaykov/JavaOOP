package P10ToP13InfernoInfinity;

import java.lang.annotation.Documented;
import java.util.Arrays;
import java.util.Objects;

@CustomClassAnnotation(
		author = "Pesho",
		revision = 3,
		description = "Used for Java OOP Advanced course - Enumerations and Annotations.",
		reviewers = {"Pesho","Svetlio"})
public enum Weapon {
	
	AXE(5,10,new Gem[4]),
	SWORD(4,6,new Gem[3]),
	KNIFE(3,4,new Gem[2]);
	
	private int minDamage;
	
	private int maxDamage;
	
	private Gem[] sockets;
	
	Weapon(int minDamage, int maxDamage, Gem[] sockets) {
		this.minDamage = minDamage;
		this.maxDamage = maxDamage;
		this.sockets = sockets;
	}
	
	public int getMinDamage() {
		
		return this.minDamage+this.getAdditionalStrength()*2+this.getAdditionalAgility();
	}
	
	private int getMaxDamage() {
		
		return this.maxDamage+this.getAdditionalStrength()*3+this.getAdditionalAgility()*4;
	}
	
	public void addGem(int socketIndex,Gem gem){
		if (socketIndex>=0 && socketIndex<this.sockets.length){
			this.sockets[socketIndex]=gem;
		}
	}
	
	public void removeGem(int socketIndex){
		if (socketIndex>=0 && socketIndex<this.sockets.length){
			this.sockets[socketIndex]=null;
		}
	}
	
	private int getAdditionalStrength() {
		return Arrays.stream(this.sockets)
				.filter(Objects::nonNull)
				.mapToInt(Gem::getStrength)
				.sum();
	}
	
	private int getAdditionalAgility() {
		return Arrays.stream(this.sockets)
				.filter(Objects::nonNull)
				.mapToInt(Gem::getAgility)
				.sum();
	}
	
	private int getAdditionalVitality() {
		return Arrays.stream(this.sockets)
				.filter(Objects::nonNull)
				.mapToInt(Gem::getVitality)
				.sum();
	}
	
	public double getItemLevel(){
		return (this.getMinDamage()+this.getMaxDamage())/2.0 + this.getAdditionalStrength() +
				this.getAdditionalAgility() + this.getAdditionalVitality();
	}
	
	@Override
	public String toString() {
		return String.format("%d-%d Damage, +%d Strength, +%d Agility, +%d Vitality",
				this.getMinDamage(),this.getMaxDamage(),this.getAdditionalStrength(),
				this.getAdditionalAgility(),this.getAdditionalVitality());
	}
	
	
}
