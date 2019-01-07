package P06_MirrorImage;

import P06_MirrorImage.models.Wizard;
import P06_MirrorImage.models.WizardImpl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		String line = reader.readLine();
		String[] params = line.split("\\s+");
		Wizard wizard = new WizardImpl(0,params[0],Integer.valueOf(params[1]),new HashMap<>());


		while (!"END".equals(line = reader.readLine().trim())) {
			params = line.split("\\s+");

			switch (params[1]) {
				case "REFLECTION":
					Wizard wizard1 = wizard.getWizards().get(Integer.valueOf(params[0]));
					wizard1.castReflection();
					break;
				case "FIREBALL":
					Wizard wizard2 = wizard.getWizards().get(Integer.valueOf(params[0]));
					wizard2.castFireBall();
					break;

			}


		}
	
	}
	
}
