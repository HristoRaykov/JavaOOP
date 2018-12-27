import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class P10ListOfPredicates {
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(reader.readLine());
		List<Integer> input = Arrays.stream(reader.readLine().split("\\s+"))
				.map(Integer::parseInt)
				.collect(Collectors.toList());
		
		Predicate<Integer> divisibleBySequence = num -> {
			for (Integer integer : input) {
				if (num % integer != 0 && integer!=1) {
					return false;
				}
			}
			return true;
		};
		
		for (int num = 1; num <= n; num++) {
			if (divisibleBySequence.test(num)) {
				System.out.print(num + " ");
			}
		}
		System.out.println();
	}
}
