package engines;

import commands.Command;
import factories.CommandFactory;
import utils.InputParser;
import utils.Reader;
import utils.Writer;

import java.io.IOException;

public class OrganismEngine implements Engine {
	
	private Reader inputReader;
	private Writer outputWriter;
	private InputParser inputParser;
	private CommandFactory commandFactory;
	
	
	public OrganismEngine(Reader inputReader, Writer outputWriter, InputParser inputParser, CommandFactory commandFactory) {
		this.inputReader = inputReader;
		this.outputWriter = outputWriter;
		this.inputParser = inputParser;
		this.commandFactory = commandFactory;
	}
	
	@Override
	public void run() {
		String inputLine=null;
		
		while (true){
			String result;
			try {
				inputLine = inputReader.readLine();
			} catch (IOException e) {
				result="Invalid input.";
				outputWriter.writeLine(result);
				continue;
			}
			if ((inputLine).equals("BEER IS COMING")){
				break;
			}
			String[] inputArgs = inputParser.parseLine(inputLine);
			Command command = commandFactory.createCommand(inputArgs);
			
			
			
			try {
				result = command.execute(inputArgs);
			} catch (Exception e) {
				result="Invalid input.";
			}
			
			outputWriter.writeLine(result);
		}
	
	}
}
