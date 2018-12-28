package loggerLibrary.models.layouts;

public interface Layout {

	String getFormattedMessage(String date,String reportLevel, String message);
	
}
