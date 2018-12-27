import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class P09CustomComparator {
	public static void main(String[] args) throws IOException {
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		List<Integer> input = Arrays.stream(reader.readLine().split("\\s+"))
				.map(Integer::parseInt)
				.collect(Collectors.toList());
		
		Comparator<Integer> comparator = (num1,num2) ->{
				if (num1 % 2 == 0 && num2 % 2 != 0) {
					return -1;
				}else if (num1 % 2 != 0 && num2 % 2 == 0){
					return 1;
				}else {
					return num1-num2;
				}
				
			};

		input.sort(comparator);
		System.out.println(input.toString().replaceAll("[\\[\\],]",""));
		
		
	}
}
