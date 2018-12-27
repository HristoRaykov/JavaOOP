import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.BiPredicate;

public class P11PredicateParty {
	
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		List<String> names = new ArrayList(Arrays.asList(reader.readLine().split("\\s+")));
		String line;
		while (!(line = reader.readLine()).equals("Party!")) {
			String[] tokens = line.split("\\s+");
			String command = tokens[0];
			String condition = tokens[1];
			String conditionValue = tokens[2];
			
			BiPredicate<String,String> startsWith = (name,pattern) -> name.startsWith(pattern);
			BiPredicate<String,String> endsWith = (name,pattern) -> name.endsWith(pattern);
			BiPredicate<String,String> isWithLength = (name,length) -> name.length()==Integer.parseInt(length);
			
			
			switch (command) {
				case "Double":
					if (condition.equals("StartsWith")){
						doubleNames(names,conditionValue,startsWith);
					}else if (condition.equals("EndsWith")) {
						doubleNames(names, conditionValue, endsWith);
					}else if (condition.equals("Length")){
						doubleNames(names, conditionValue, isWithLength);
					}
					break;
				case "Remove":
					if (condition.equals("StartsWith")){
						removeNames(names,conditionValue,startsWith);
					}else if (condition.equals("EndsWith")) {
						removeNames(names, conditionValue, endsWith);
					}else if (condition.equals("Length")){
						removeNames(names, conditionValue, isWithLength);
					}
					break;
			}
			
		}
		
		if (names.size()==0){
			System.out.println("Nobody is going to the party!");
		}else {
			System.out.println(names.toString().replaceAll("[\\[\\]]","")+" are going to the party!");
			System.out.println();
		}
	}
	
	private static void removeNames(List<String> names, String conditionValue, BiPredicate<String, String> predicate) {
		names.removeIf(name -> predicate.test(name,conditionValue));
	}
	
	private static void doubleNames(List<String> names, String conditionValue, BiPredicate<String, String> predicate) {
		for (int i = names.size()-1; i >= 0; i--) {
			if (predicate.test(names.get(i),conditionValue)){
				names.add(i,names.get(i));
			}
		}
	}
}
