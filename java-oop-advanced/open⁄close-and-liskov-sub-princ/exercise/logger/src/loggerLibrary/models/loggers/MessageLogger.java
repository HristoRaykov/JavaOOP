package loggerLibrary.models.loggers;

import loggerLibrary.models.appenders.Appender;
import loggerLibrary.models.appenders.ReportLevel;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class MessageLogger implements Logger {
	
	private List<Appender> appenders;
	
	public MessageLogger() {
		this.appenders = new ArrayList<>();
	}
	
	@Override
	public void addAppender(Appender appender){
		this.appenders.add(appender);
	}
	
	@Override
	public void logInfo(String dateTime, String message) {
		List<Appender> appenders = this.getAppendersByReportLevel(ReportLevel.INFO);
		appenders
				.forEach(appender -> appender.appendMessage(dateTime,"INFO",message));
	}
	
	@Override
	public void logWarning(String dateTime, String message) {
		List<Appender> appenders = this.getAppendersByReportLevel(ReportLevel.WARNING);
		appenders
				.forEach(appender -> appender.appendMessage(dateTime,"WARNING",message));
	}
	
	@Override
	public void logError(String dateTime, String message) {
		List<Appender> appenders = this.getAppendersByReportLevel(ReportLevel.ERROR);
		appenders
				.forEach(appender -> appender.appendMessage(dateTime,"ERROR",message));
	}
	
	@Override
	public void logCritical(String dateTime, String message) {
		List<Appender> appenders = this.getAppendersByReportLevel(ReportLevel.CRITICAL);
		appenders
				.forEach(appender -> appender.appendMessage(dateTime,"CRITICAL",message));
	}
	
	@Override
	public void logFatal(String dateTime, String message) {
		List<Appender> appenders = this.getAppendersByReportLevel(ReportLevel.FATAL);
		appenders
				.forEach(appender -> appender.appendMessage(dateTime,"FATAL",message));
	}
	
	private List<Appender> getAppendersByReportLevel(ReportLevel reportLevel){
		return this.appenders.stream()
				.filter(appender -> appender.getReportLevel().compareTo(reportLevel)<=0)
				.collect(Collectors.toList());
	}
	
	@Override
	public String toString() {
		StringBuilder result = new StringBuilder();
		
		result.append("Logger info").append(System.lineSeparator());
		for (Appender appender : appenders) {
			result.append(appender.toString()).append(System.lineSeparator());
		}
		
		return result.toString();
	}
}
