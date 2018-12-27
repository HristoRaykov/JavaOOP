package utils;

public class InputParserImpl implements InputParser {
	
	@Override
	public String[] parseLine(String line) {
		return line.split("\\s+");
	}
}
