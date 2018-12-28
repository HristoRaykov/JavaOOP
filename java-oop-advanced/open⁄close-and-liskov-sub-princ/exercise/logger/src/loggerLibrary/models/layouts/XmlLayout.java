package loggerLibrary.models.layouts;

public class XmlLayout implements Layout {
	
	@Override
	public String getFormattedMessage(String date, String reportLevel, String message) {
		return String.format("<log>\n" +
				"\t<date>%s</date>\n" +
				"\t<level>%s</level>\n" +
				"\t<message>%s</message>\n" +
				"</log>",date,reportLevel,message);
	}
}
