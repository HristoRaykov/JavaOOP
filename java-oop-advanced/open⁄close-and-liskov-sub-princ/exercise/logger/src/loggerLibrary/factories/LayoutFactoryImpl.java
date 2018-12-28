package loggerLibrary.factories;

import loggerLibrary.models.layouts.Layout;

import java.lang.reflect.InvocationTargetException;

public class LayoutFactoryImpl implements LayoutFactory {
	
	private final String LAYOUT_PACKAGE_PATH = "loggerLibrary.models.layouts.";
	
	@Override
	public Layout createLayout(String layoutName) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
		Layout layout = null;
		Class<Layout> layoutClass = (Class<Layout>) Class.forName(LAYOUT_PACKAGE_PATH + layoutName);
		layout = layoutClass.getDeclaredConstructor().newInstance();
		
		return layout;
	}
}
