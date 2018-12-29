package utils;

import interfaces.Reader;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ConsoleReader implements Reader {
	
	BufferedReader reader;
	
	public ConsoleReader() {
		reader = new BufferedReader(new InputStreamReader(System.in));
	}
	
	@Override
	public String readLine() throws IOException {
		return reader.readLine();
	}
}
