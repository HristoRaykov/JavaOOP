package P06_MirrorImage.models;


import java.util.Map;

public class WizardImpl implements Wizard {
	
	private Map<Integer, Wizard> wizards;
	
	private int id;
	
	private String name;
	
	private int magicPower;
	
	private Wizard[] mirrorImages;
	
	public WizardImpl(int id, String name, int magicPower, Map<Integer, Wizard> wizards) {
		this.id = id;
		this.name = name;
		this.magicPower = magicPower;
		this.wizards = wizards;
		this.wizards.putIfAbsent(this.getId(), this);
	}
	
	@Override
	public int getId() {
		return id;
	}
	
	private String getName() {
		return name;
	}
	
	private int getMagicPower() {
		return magicPower;
	}
	
	@Override
	public Map<Integer, Wizard> getWizards() {
		return wizards;
	}
	
	@Override
	public void castReflection() {
		int id = this.getId()*2;
		System.out.println(String.format("%s %d casts Reflection", this.getName(), this.getId()));
		if (this.mirrorImages == null) {
			this.mirrorImages = new Wizard[2];
			for (int i = 0; i < 2; i++) {
				this.mirrorImages[i]= new WizardImpl(++id, this.getName(), this.getMagicPower() / 2, wizards);
			}
		} else {
			for (Wizard mirrorImage : this.mirrorImages) {
				if (mirrorImage != null) {
					mirrorImage.castReflection();
				}
			}
		}
	}
	
	@Override
	public void castFireBall() {
		System.out.println(String.format("%s %d casts Fireball for %d damage",
				this.getName(), this.getId(), this.getMagicPower()));
		if (this.mirrorImages != null) {
			for (Wizard mirrorImage : this.mirrorImages) {
				if (mirrorImage!=null) {
					mirrorImage.castFireBall();
				}
			}
		}
	}
}
