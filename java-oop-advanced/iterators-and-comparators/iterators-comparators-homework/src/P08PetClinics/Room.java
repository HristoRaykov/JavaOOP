package P08PetClinics;

public class Room {
	
	private Pet pet;
	
	public Room() {
	}
	
	public boolean isEmpty(){
		return this.getPet()==null;
	}
	
	public Pet getPet() {
		return pet;
	}
	
	public void setPet(Pet pet) {
		this.pet = pet;
	}
	
	@Override
	public String toString() {
		return this.getPet().getName()+" "+this.getPet().getAge()+" "+this.getPet().getKind();
	}
}
