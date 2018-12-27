package P08PetClinics;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Iterator;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		PetClinics clinics = new PetClinics();
		
		int n = Integer.valueOf(reader.readLine());
		
		while (n-- > 0) {
			String[] params = reader.readLine().split("\\s+");
			
			switch (params[0]) {
				case "Create":
					if ("Pet".equals(params[1])) {
						Pet pet = new Pet(params[2], Integer.valueOf(params[3]), params[4]);
						clinics.createHomelessPet(pet);
					} else if ("Clinic".equals(params[1])) {
						PetClinic clinic = null;
						
						try {
							clinic = new PetClinic(params[2], Integer.valueOf(params[3]));
						} catch (IllegalArgumentException e) {
							System.out.println(e.getMessage());
							continue;
						}
						
						clinics.addClinic(clinic);
						
					}
					break;
				case "Add":
					Pet pet = null;
					try {
						pet = clinics.getHomelessPet(params[1]);
					} catch (NullPointerException e) {
						System.out.println(e.getMessage());
					}
					PetClinic clinic = null;
					try {
						clinic = clinics.getClinic(params[2]);
					} catch (NullPointerException e) {
						System.out.println(e.getMessage());
					}
					System.out.println(addPetToClinic(pet, clinic));
					break;
				case "Release":
					PetClinic clinic2 = null;
					try {
						clinic2 = clinics.getClinic(params[1]);
					} catch (NullPointerException e) {
						System.out.println(e.getMessage());
					}
					System.out.println(releaseClinic(clinic2));
					break;
				case "HasEmptyRooms":
					PetClinic clinic1 = clinics.getClinic(params[1]);
					System.out.println(clinic1.hasEmptyRooms());
					break;
				case "Print":
					if (params.length == 2) {
						clinics.print(params[1]);
					} else if (params.length == 3) {
						clinics.print(params[1], Integer.valueOf(params[2]));
					}
					break;
				
				
			}
			
			
		}
		
		
	}
	
	private static boolean releaseClinic(PetClinic clinic2) {
		Iterator<Room> releaseIterator = clinic2.getReleaseIterator();
		while (releaseIterator.hasNext()) {
			Room room = releaseIterator.next();
			if (!room.isEmpty()) {
				room.setPet(null);
				return true;
			}
		}
		return false;
	}
	
	private static boolean addPetToClinic(Pet pet, PetClinic clinic) {
		Iterator<Room> accommodationIterator = clinic.getAccommodationIterator();
		while (accommodationIterator.hasNext()) {
			Room room = accommodationIterator.next();
			if (room.isEmpty()) {
				room.setPet(pet);
				return true;
			}
		}
		return false;
	}
}
