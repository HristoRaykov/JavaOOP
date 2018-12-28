package loggerLibrary.models.file;

public class LogFile implements File {
	
	private StringBuilder messages;
	
	public LogFile() {
		this.messages = new StringBuilder();
	}
	
	@Override
	public void write(String message) {
		this.messages.append(message);
	}
	
	@Override
	public int getSize() {
		int size = 0;
		for (char ch : messages.toString().toCharArray()) {
			if (Character.isAlphabetic(ch)){
				size += ch;
			}
		}
		return size;
	}
}
