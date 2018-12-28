package loggerLibrary.core;

import loggerLibrary.models.appenders.ReportLevel;
import loggerLibrary.models.loggers.Logger;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class LoggerController implements Controller {
	
	private Logger logger;
	
	public LoggerController(Logger logger) {
		this.logger = logger;
	}
	
	@Override
	public void logByReportLevel(String... params) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
		ReportLevel reportLevel = ReportLevel.valueOf(params[0]);
		String methodName = "log"+reportLevel.toString();
		String dateTime = params[1];
		String message = params[2];
		Class<Logger> loggerClass = Logger.class;
		Method method = loggerClass.getMethod(methodName,String.class,String.class);
		method.invoke(this.logger,dateTime,message);
		
	}
}
