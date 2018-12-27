package P10ToP13InfernoInfinity;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		Map<String, Weapon> weapons = new HashMap<>();
		String line;
		
		while (!"END".equals(line = reader.readLine())) {
			String[] params = line.split(";");
			CustomClassAnnotation annotation = Weapon.class.getAnnotation(CustomClassAnnotation.class);
			
			switch (params[0]) {
				case "Create":
					Weapon weapon = Weapon.valueOf(params[1]);
					weapons.putIfAbsent(params[2], weapon);
					break;
				case "Add":
					Weapon weaponToAddGem = weapons.get(params[1]);
					weaponToAddGem.addGem(Integer.parseInt(params[2]), Gem.valueOf(params[3]));
					break;
				case "Remove":
					Weapon weaponToRemoveGem = weapons.get(params[1]);
					weaponToRemoveGem.removeGem(Integer.parseInt(params[2]));
					break;
				case "Print":
					String weaponName = params[1];
					Weapon weaponToPrint = weapons.get(weaponName);
					System.out.println(String.format("%s: %s", weaponName, weaponToPrint));
					break;
				case "Compare":
					String weaponName1 = params[1];
					String weaponName2 = params[2];
					Weapon weapon1 = weapons.get(weaponName1);
					Weapon weapon2 = weapons.get(weaponName2);
					WeaponComparator comparator = new WeaponComparator();
					
					if (comparator.compare(weapon1, weapon2) >= 0) {
						System.out.println(String.format("%s: %s (Item Level: %.1f)",
								weaponName1, weapon1, weapon1.getItemLevel()));
					} else {
						System.out.println(String.format("%s: %s (Item Level: %.1f)",
								weaponName2, weapon2, weapon2.getItemLevel()));
					}
					break;
				case "Author":
					System.out.println(String.format("Author: %s",annotation.author()));
					break;
				case "Revision":
					System.out.println(String.format("Revision: %s",annotation.revision()));
					break;
				case "Description":
					System.out.println(String.format("Class description: %s",annotation.description()));
					break;
				case "Reviewers":
					System.out.println(String.format("Reviewers: %s",String.join(", ",annotation.reviewers())));
					break;
			}
		}
	}
}


