import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.function.Consumer;

public class P01ConsumerPrint {
	
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		String[] input = reader.readLine().split("\\s+");
		
		Consumer<String[]> print = arr -> Arrays.stream(arr).forEach(System.out::println);
		
		print.accept(input);
	
	}
}
