package P08PetClinics;

import java.util.HashMap;
import java.util.Map;

public class PetClinics {
	
	private Map<String, PetClinic> clinics;
	
	private Map<String, Pet> homelessPets;
	
	public PetClinics() {
		clinics = new HashMap<>();
		homelessPets = new HashMap<>();
	}
	
	
	public void addClinic(PetClinic clinic) {
		this.clinics.putIfAbsent(clinic.getName(), clinic);
	}
	
	public PetClinic getClinic(String clinicName) throws NullPointerException {
		PetClinic clinic = null;
		try {
			clinic =this.clinics.get(clinicName);
		}catch (NullPointerException e){
			throw  new NullPointerException("Invalid Operation!");
		}
		
		return clinic;
	}
	
	public Pet getHomelessPet(String petName) throws NullPointerException {
		Pet pet = null;
		try {
			pet =  this.homelessPets.get(petName);
		} catch (NullPointerException e) {
			throw new NullPointerException("Invalid Operation!");
		}
		
		return pet;
	}
	
	public void createHomelessPet(Pet pet) {
		this.homelessPets.putIfAbsent(pet.getName(), pet);
	}
	
	public void print(String clinicName) {
		this.clinics.get(clinicName)
				.forEach(room -> {
					if (room.isEmpty()){
						System.out.println("Room empty");
					}else {
						System.out.println(room);
					}
				});
	}
	
	public void print(String clinicName, int roomNumber) {
		Room room = this.getClinic(clinicName).getRooms()[roomNumber-1];
		if (room.isEmpty()){
			System.out.println("Room empty");
		}
		System.out.println(room);
	}
}
