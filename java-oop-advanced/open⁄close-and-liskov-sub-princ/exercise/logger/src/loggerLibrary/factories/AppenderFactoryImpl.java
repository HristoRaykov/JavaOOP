package loggerLibrary.factories;

import loggerLibrary.models.appenders.Appender;
import loggerLibrary.models.appenders.FileAppender;
import loggerLibrary.models.appenders.ReportLevel;
import loggerLibrary.models.file.LogFile;
import loggerLibrary.models.layouts.Layout;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class AppenderFactoryImpl implements AppenderFactory {
	
	private final String APPENDER_PACKAGE_PATH = "loggerLibrary.models.appenders.";
	
	private LayoutFactory layoutFactory;
	
	public AppenderFactoryImpl(LayoutFactory layoutFactory) {
		this.layoutFactory = layoutFactory;
	}
	
	@Override
	@SuppressWarnings("unchecked")
	public Appender createAppender(String... params) throws ClassNotFoundException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
		String appenderName = params[0];
		String layoutName = params[1];
		Layout layout = layoutFactory.createLayout(layoutName);
		ReportLevel reportLevel = params.length==3 ? ReportLevel.valueOf(params[2]) : null;
		Appender appender = null;
		Class<Appender> appenderClass = (Class<Appender>) Class.forName(APPENDER_PACKAGE_PATH+appenderName);
		Constructor<Appender> constructor = null;
		
		if (reportLevel==null) {
			constructor = appenderClass.getDeclaredConstructor(Layout.class);
			constructor.setAccessible(true);
			appender = constructor.newInstance(layout);
		}else {
			constructor = appenderClass.getDeclaredConstructor(Layout.class,ReportLevel.class);
			constructor.setAccessible(true);
			appender = constructor.newInstance(layout,reportLevel);
		}
		
		if (appender instanceof FileAppender){
			((FileAppender) appender).setFile(new LogFile());
		}
		
		return appender;
	}
	
	
}
