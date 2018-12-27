import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class P08FindTheSmallestElement {
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		List<Integer> input = Arrays.stream(reader.readLine().split("\\s+"))
				.map(Integer::parseInt)
				.collect(Collectors.toList());
		
		Function<List<Integer>,Integer> smallestElementIndex = arr -> {
			return arr.lastIndexOf(arr.stream().mapToInt(Integer::intValue).min().getAsInt());
		};
		
		System.out.println(smallestElementIndex.apply(input));
		
	}
}
