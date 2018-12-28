package loggerLibrary.models.appenders;

public enum ReportLevel {
	
	INFO,WARNING,ERROR,CRITICAL,FATAL;
	
	
	@Override
	public String toString() {
		return this.name().charAt(0)+this.name().substring(1).toLowerCase();
	}
}
