package P01ListyIterator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String line;
		ListyIterator<String> listyIterator = null;
		
		while (!"END".equals((line = reader.readLine()))) {
			List<String> params = Arrays.stream(line.split("\\s+")).collect(Collectors.toList());
			
			switch (params.get(0)) {
				case "Create":
					listyIterator = new ListyIterator<>(params.stream().skip(1).collect(Collectors.toList()));
					break;
				case "Move":
					System.out.println(listyIterator.Move());
					break;
				case "Print":
					try {
						listyIterator.print();
					} catch (Exception e) {
						System.out.println(e.getMessage());
					}
					break;
				case "HasNext":
					System.out.println(listyIterator.hasNext());
					break;
			}
			
			
		}
		
		
	}
}
