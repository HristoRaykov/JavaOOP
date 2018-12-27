package P04Froggy;

import org.w3c.dom.stylesheets.LinkStyle;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
	
	public static void main(String[] args) throws IOException {
	
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		Integer[] ints = Arrays.stream(reader.readLine().split("[, ]+")).map(Integer::valueOf).toArray(Integer[]::new);
		
		Lake<Integer> lake = new Lake<>(ints);
		List<String> result = new ArrayList<>();
		
		for (Integer integer : lake) {
			result.add(integer.toString());
		}
		
		System.out.println(String.join(", ",result));
	}
}
