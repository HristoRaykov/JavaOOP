package P05_KingsGambitExtended;

import P05_KingsGambitExtended.models.Footman;
import P05_KingsGambitExtended.models.King;
import P05_KingsGambitExtended.models.RoyalGuard;
import P05_KingsGambitExtended.models.interfaces.Defender;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		King king = new King(reader.readLine().trim());
		
		String line = reader.readLine();
		String[] params = line.split("\\s+");
		Arrays.stream(params)
				.forEach(name -> new RoyalGuard(name, king));
		
		line = reader.readLine();
		params = line.split("\\s+");
		Arrays.stream(params)
				.forEach(name -> new Footman(name,king));
		
		while (!"End".equals(line = reader.readLine())) {
			params = line.split("\\s+");
			
			switch (params[0]) {
				
				case "Attack":
					king.respondToAttack();
					break;
				case "Kill":
					Defender defender = king.getDefenderByName(params[1]);
					defender.attacked();
					break;
				
			}
		}
		
		
	}
	
	
}
