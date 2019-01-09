package core;

import contracts.*;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class EngineImpl implements Engine {
	
	private final Reader reader;
	private Battlefield battlefield;
	
	
	public EngineImpl(Reader reader, Battlefield battlefield) {
		this.reader = reader;
		this.battlefield = battlefield;
	}
	
	
	@Override
	public void run() throws IOException, NoSuchMethodException, ClassNotFoundException {
		String line = reader.readLine();
		
		
		while (!line.equals("Peace")){
			List<String> params = Arrays.stream(line.split("\\s+")).collect(Collectors.toList());
			
			switch (params.get(0)){
				case "CreateParticipant":
					this.battlefield.createParticipant(params.get(1),params.get(2));
					break;
				case "CreateAction":
					this.battlefield.createAction(params.get(1),params.stream().skip(2).toArray(String[]::new));
					break;
				case "CreateSpecial":
					
					break;
				case "StatParticipants":
					this.battlefield.reportParticipants();
					break;
				case "StatActions":
					this.battlefield.reportActions();
					break;
				
			}
			
			line = reader.readLine();
		}
		
		
		
	}
	
	
}
