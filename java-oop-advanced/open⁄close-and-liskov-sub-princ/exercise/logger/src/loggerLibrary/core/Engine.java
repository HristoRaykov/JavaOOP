package loggerLibrary.core;

import loggerLibrary.factories.AppenderFactory;
import loggerLibrary.models.appenders.Appender;
import loggerLibrary.models.loggers.Logger;
import loggerLibrary.utils.io.Reader;
import loggerLibrary.utils.io.Writer;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

public class Engine implements Runnable {
	
	
	private final Reader reader;
	private final Writer writer;
	private final AppenderFactory appenderFactory;
	private Logger logger;
	private Controller loggerController;
	
	public Engine(Reader reader, Writer writer, AppenderFactory appenderFactory, Logger logger) {
		this.reader = reader;
		this.writer = writer;
		this.appenderFactory = appenderFactory;
		this.logger = logger;
		this.loggerController = initController(logger);
	}
	
	
	
	
	@Override
	public void run() throws IOException, ClassNotFoundException, NoSuchMethodException, InstantiationException, IllegalAccessException, InvocationTargetException {
		String line = reader.readLine();
		String[] params = null;
		int appendersCount = Integer.parseInt(line);
		while (appendersCount-->0){
			line = reader.readLine();
			params = line.split("\\s+");
			Appender appender = appenderFactory.createAppender(params);
			this.logger.addAppender(appender);
		}
		
		while (true){
			line=reader.readLine();
			if ("END".equals(line)){
				System.out.println(logger.toString());
				break;
			}
			params = line.split("\\|");
			this.loggerController.logByReportLevel(params);
		}
		
	}
	
	private Controller initController(Logger logger) {
		return new LoggerController(logger);
	}
}
