package loggerLibrary.models.appenders;

import loggerLibrary.models.layouts.Layout;

public abstract class BaseAppender implements Appender {

	private Layout layout;
	
	private ReportLevel reportLevel;
	
	private int messageCount;
	
	protected BaseAppender(Layout layout) {
		this.layout = layout;
		this.reportLevel = ReportLevel.INFO;
		this.messageCount = 0;
	}
	
	protected BaseAppender(Layout layout, ReportLevel reportLevel) {
		this.layout = layout;
		this.reportLevel = reportLevel;
	}
	
	public Layout getLayout() {
		return layout;
	}
	
	public ReportLevel getReportLevel() {
		return reportLevel;
	}
	
	public int getMessageCount() {
		return messageCount;
	}
	
	protected void incrementMessageCount() {
		this.messageCount++;
	}
	
	@Override
	public String toString() {
		StringBuilder result = new StringBuilder();
		
		result
				.append("Appender type: ")
				.append(this.getClass().getSimpleName())
				.append(", Layout type: ")
				.append(this.layout.getClass().getSimpleName())
				.append(", Report level: ")
				.append(this.getReportLevel().name())
				.append(", Messages appended: ")
				.append(this.getMessageCount());
				
		return result.toString();
	}
}
