package loggerLibrary.models.appenders;

import loggerLibrary.models.layouts.Layout;

public interface Appender {
	
	void appendMessage(String dateTime,String reportLevel ,String message);
	
	Layout getLayout();
	
	ReportLevel getReportLevel();
	
	int getMessageCount();
	
	


}
