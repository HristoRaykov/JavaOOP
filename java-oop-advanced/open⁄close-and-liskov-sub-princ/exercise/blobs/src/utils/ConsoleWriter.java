package utils;

import interfaces.Writer;

public class ConsoleWriter implements Writer {
	
	@Override
	public void writeLine(String line) {
		System.out.println(line);
	}
	
}
