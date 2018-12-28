package loggerLibrary.core;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

public interface Runnable {
	
	void run() throws IOException, ClassNotFoundException, NoSuchMethodException, InstantiationException, IllegalAccessException, InvocationTargetException;
}
