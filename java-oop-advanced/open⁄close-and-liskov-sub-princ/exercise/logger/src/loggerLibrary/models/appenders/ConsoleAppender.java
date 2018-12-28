package loggerLibrary.models.appenders;

import loggerLibrary.models.layouts.Layout;

public class ConsoleAppender extends BaseAppender {
	
	
	protected ConsoleAppender(Layout layout) {
		super(layout);
	}
	
	public ConsoleAppender(Layout layout, ReportLevel reportLevel) {
		super(layout, reportLevel);
	}
	
	@Override
	public void appendMessage(String dateTime, String reportLevel, String message) {
		String formattedMessage = super.getLayout().getFormattedMessage(dateTime,reportLevel,message);
		
		System.out.println(formattedMessage);
		super.incrementMessageCount();
	}
}
