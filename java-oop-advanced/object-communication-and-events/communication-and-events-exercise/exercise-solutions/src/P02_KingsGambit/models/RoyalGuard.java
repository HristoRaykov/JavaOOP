package P02_KingsGambit.models;

import P02_KingsGambit.models.interfaces.Defender;

public class RoyalGuard extends BaseUnit implements Defender {
	
	public RoyalGuard(String name) {
		super(name);
	}
	
	@Override
	public void defendKing() {
		System.out.println(String.format("Royal Guard %s is defending!",super.getName()));
	}
}
