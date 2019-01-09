package boatRacing.Core;

import java.io.BufferedReader;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class AppEngine implements Runnable {
	
	private CommandHandler commandHandler;
	
	private BufferedReader reader;
	
	public AppEngine(CommandHandler commandHandler, BufferedReader reader) {
		this.commandHandler = commandHandler;
		this.reader = reader;
	}
	
	@Override
	public void run() {
		while (true) {
			try {
				String line = reader.readLine();
				
				if (line.equals("End")) {
					break;
				}
				
				List<String> tokens = Arrays.asList(line.split("\\\\"));
				String name = tokens.get(0);
				List<String> params = tokens.stream().skip(1).collect(Collectors.toList());
				
				String commandResult = this.commandHandler.ExecuteCommand(name, params);
				System.out.println(commandResult);
				
			} catch (Exception ex) {
				System.out.println(ex.getMessage());
			}
			
		}
	}
	
	
}
