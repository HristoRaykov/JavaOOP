package P02_KingsGambit.models;

import P02_KingsGambit.models.interfaces.Defender;

public class Footman extends BaseUnit implements Defender {
	
	public Footman(String name) {
		super(name);
	}
	
	@Override
	public void defendKing() {
		System.out.println(String.format("Footman %s is panicking!",super.getName()));
	}
	
}
