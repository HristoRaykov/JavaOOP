package P02_KingsGambit;

import P02_KingsGambit.models.Footman;
import P02_KingsGambit.models.King;
import P02_KingsGambit.models.RoyalGuard;

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
				.map(RoyalGuard::new)
				.forEach(king::addDefender);
		
		line = reader.readLine();
		params = line.split("\\s+");
		Arrays.stream(params)
				.map(Footman::new)
				.forEach(king::addDefender);
		
		while (!"End".equals(line = reader.readLine())) {
			params = line.split("\\s+");
			
			switch (params[0]) {
				
				case "Attack":
					king.respondToAttack();
					break;
				case "Kill":
					king.removeDefender(params[1]);
					break;
				
			}
		}
		
		
	}
	
	
}
