package loggerLibrary.core;

import java.lang.reflect.InvocationTargetException;

public interface Controller {
	
	void logByReportLevel(String... params) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException;
	
}
