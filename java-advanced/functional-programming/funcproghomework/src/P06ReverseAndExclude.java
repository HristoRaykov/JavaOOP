import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class P06ReverseAndExclude {
	
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		List<Integer> input = Arrays.stream(reader.readLine().split("\\s+"))
				.map(Integer::parseInt).collect(Collectors.toList());
		
		int n = Integer.parseInt(reader.readLine());
		
		Collections.reverse(input);
		
		input.removeIf(num -> num%n==0);
		
		System.out.println(input.toString().replaceAll("[\\[\\],]",""));
		
	}
}
