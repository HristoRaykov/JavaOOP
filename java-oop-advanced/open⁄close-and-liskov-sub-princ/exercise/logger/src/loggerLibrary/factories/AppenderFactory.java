package loggerLibrary.factories;

import loggerLibrary.models.appenders.Appender;

import java.lang.reflect.InvocationTargetException;

public interface AppenderFactory {
	
	Appender createAppender(String... params) throws ClassNotFoundException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException;

}
