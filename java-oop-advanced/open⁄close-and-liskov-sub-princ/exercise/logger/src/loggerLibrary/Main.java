package loggerLibrary;

import loggerLibrary.core.Engine;
import loggerLibrary.core.LoggerController;
import loggerLibrary.factories.AppenderFactory;
import loggerLibrary.factories.AppenderFactoryImpl;
import loggerLibrary.factories.LayoutFactory;
import loggerLibrary.factories.LayoutFactoryImpl;
import loggerLibrary.models.loggers.Logger;
import loggerLibrary.models.loggers.MessageLogger;
import loggerLibrary.utils.io.ConsoleReader;
import loggerLibrary.utils.io.ConsoleWriter;
import loggerLibrary.utils.io.Reader;
import loggerLibrary.utils.io.Writer;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

public class Main {

    public static void main(String[] args) throws IOException, ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
	
	    Reader reader = new ConsoleReader();
	    Writer writer = new ConsoleWriter();
	    LayoutFactory layoutFactory = new LayoutFactoryImpl();
	    AppenderFactory appenderFactory = new AppenderFactoryImpl(layoutFactory);
	    Logger logger = new MessageLogger();
		
	    Engine engine = new Engine(reader,writer,appenderFactory,logger);
    
        engine.run();
    }
}
