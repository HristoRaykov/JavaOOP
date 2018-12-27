package P03StackIterator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	
	public static void main(String[] args) throws IOException {
	
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		String line;
		MyStack<Integer> stack = new MyStack<>();
		
		while (true){
			
			if ("END".equals(line=reader.readLine())){
				for (Integer integer : stack) {
					System.out.println(integer);
				}
				for (Integer integer : stack) {
					System.out.println(integer);
				}
				
				break;
			}
			
			String[] tokens = line.split("\\s+",2);
			String command = tokens[0];
			Integer[] elements = null;
			if (tokens.length>1){
				elements = Arrays.stream(tokens[1].split("[, ]+")).map(Integer::valueOf).toArray(Integer[]::new);
			}
			
			switch (command){
				case "Push":
					for (Integer element : elements) {
						stack.push(element);
					}
					break;
				case  "Pop":
					try{
						stack.pop();
					}catch (IndexOutOfBoundsException e){
						System.out.println(e.getMessage());
					}
					break;
			}
			
			
			
		}
	
	
	}
}
