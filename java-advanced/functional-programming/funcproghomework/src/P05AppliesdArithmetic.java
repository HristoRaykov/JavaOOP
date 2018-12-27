import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.stream.Collectors;

public class P05AppliesdArithmetic {
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		List<Long> input = Arrays.stream(reader.readLine().split("\\s+")).map(Long::parseLong).collect(Collectors.toList());
		
		BiConsumer<List<Long>, String> arithmetic = (arr, condition) -> {
			if (condition.equals("add")) {
				for (int i = 0; i < input.size(); i++) {
					input.set(i, input.get(i) + 1);
				}
			} else if (condition.equals("subtract")) {
				for (int i = 0; i < input.size(); i++) {
					input.set(i, input.get(i) - 1);
				}
			} else if (condition.equals("multiply")) {
				for (int i = 0; i < input.size(); i++) {
					input.set(i, input.get(i) * 2);
				}
			} else if (condition.equals("print")) {
				arr.forEach(num -> System.out.print(num + " "));
				System.out.println();
			}
		};
		
		while (true) {
			String condition = reader.readLine();
			if (condition.equalsIgnoreCase("end")) {
				break;
			}
			
			arithmetic.accept(input, condition);
		}
		
	}
}
