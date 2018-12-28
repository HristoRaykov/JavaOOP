package loggerLibrary.factories;

import loggerLibrary.models.layouts.Layout;

import java.lang.reflect.InvocationTargetException;

public interface LayoutFactory {
	
	Layout createLayout(String layoutName) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException;
	
}
