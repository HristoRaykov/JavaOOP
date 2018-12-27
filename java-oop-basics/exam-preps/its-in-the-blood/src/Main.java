import engines.Engine;
import engines.OrganismEngine;
import factories.CommandFactory;
import factories.CommandFactoryImpl;
import repositories.OrganismRepository;
import repositories.Repository;
import utils.*;

public class Main {
	
	public static void main(String[] args) {
		Reader inputReader = new ConsoleReader();
		Writer outputWriter = new ConsoleWriter();
		InputParser inputParser = new InputParserImpl();
		Repository organismRepository = new OrganismRepository();
		
		CommandFactory commandFactory = new CommandFactoryImpl(organismRepository);
		
		
		Engine organismEngine = new OrganismEngine(inputReader, outputWriter, inputParser, commandFactory);
		
		
		organismEngine.run();
		
		
	}
}
