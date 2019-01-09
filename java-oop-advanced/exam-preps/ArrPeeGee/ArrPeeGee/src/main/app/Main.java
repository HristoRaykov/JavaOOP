import contracts.*;
import core.BattleFieldImpl;
import core.EngineImpl;
import factory.ActionFactoryImpl;
import factory.TargetableFactoryImpl;
import io.ConsoleReader;
import io.ConsoleWriter;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException, NoSuchMethodException, ClassNotFoundException {

        Reader reader = new ConsoleReader();
        Writer writer = new ConsoleWriter();
	    
	    TargetableFactory targetableFactory = new TargetableFactoryImpl();
	    ActionFactory actionFactory = new ActionFactoryImpl();
	    Battlefield battleField = new BattleFieldImpl(writer,targetableFactory,actionFactory);
	    
	    
	    Engine engine = new EngineImpl(reader,battleField);
	    
	    engine.run();
	    

    }
}
