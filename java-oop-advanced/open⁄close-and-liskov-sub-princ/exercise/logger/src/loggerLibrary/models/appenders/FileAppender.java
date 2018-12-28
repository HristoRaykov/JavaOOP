package loggerLibrary.models.appenders;

import loggerLibrary.models.file.File;
import loggerLibrary.models.layouts.Layout;

public class FileAppender extends BaseAppender {
	
	private File file;
	
	protected FileAppender(Layout layout) {
		super(layout);
	}
	
	public FileAppender(Layout layout, ReportLevel reportLevel) {
		super(layout, reportLevel);
	}
	
	public void setFile(File file) {
		this.file = file;
	}
	
	@Override
	public void appendMessage(String dateTime, String reportLevel, String message) {
		String formattedMessage = super.getLayout().getFormattedMessage(dateTime, reportLevel, message);
		
		file.write(formattedMessage);
		
		super.incrementMessageCount();
	}
	
	@Override
	public String toString() {
		return super.toString() + ", File size: " + this.file.getSize();
	}
}
