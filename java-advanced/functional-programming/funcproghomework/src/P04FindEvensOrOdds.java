import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class P04FindEvensOrOdds {
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		List<Integer> input = Arrays.stream(reader.readLine().split("\\s+")).map(Integer::parseInt).collect(Collectors.toList());
		
		int lowerBound = input.get(0);
		int upperBound = input.get(1);
		String conditionString = reader.readLine();
		
		Predicate<Integer> conditionPredicate = getPredicate(conditionString);
		
		printOnCondition(lowerBound, upperBound, conditionPredicate);
		
	}
	
	private static Predicate<Integer> getPredicate(String conditionString) {
			if (conditionString.equalsIgnoreCase("odd")) {
				return num -> num % 2 != 0;
			}
			if (conditionString.equalsIgnoreCase("even")) {
				return num  -> num % 2 == 0;
			}
			
		return null;
	}
	
	private static void printOnCondition(int lowerBound, int upperBound, Predicate<Integer> conditionPredicate) {
		for (int i = lowerBound; i <= upperBound ; i++) {
			if (conditionPredicate.test(i)) {
				System.out.print(i + " ");
			}
		}
	}
}
