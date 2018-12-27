package P07CustomList;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	
	public static void main(String[] args) throws IOException {
	
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String[] params;
		CustomList<String> list = new CustomList<>();
		
		while (true){
			params  = reader.readLine().split("\\s+");
			if (params[0].equals("END")){
				break;
			}
			switch (params[0]) {
				case "Add":
					list.add(params[1]);
					break;
				case "Remove":
					list.remove(Integer.valueOf(params[1]));
					break;
				case "Contains":
					System.out.println(list.contains(params[1]));
					break;
				case "Swap":
					list.swap(Integer.valueOf(params[1]), Integer.valueOf(params[2]));
					break;
				case "Greater":
					System.out.println(list.countGreaterThan(params[1]));
					break;
				case "Max":
					System.out.println(list.getMax());
					break;
				case "Min":
					System.out.println(list.getMin());
					break;
				case "Print":
					for (int i = 0; i < list.size(); i++) {
						System.out.println(list.get(i));
					}
					break;
			}
		}
	
	}
}
