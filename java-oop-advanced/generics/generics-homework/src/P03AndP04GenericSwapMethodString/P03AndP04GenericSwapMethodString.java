package P03AndP04GenericSwapMethodString;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class P03AndP04GenericSwapMethodString {
	
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		List<Box> elements = new ArrayList<>();
		
		int n = Integer.valueOf(reader.readLine());
		for (int i = 0; i < n; i++) {
			elements.add(new Box<>(Integer.valueOf(reader.readLine())));
		}
		
		int[] indexes = Arrays.stream(reader.readLine().split("\\s+")).mapToInt(Integer::valueOf).toArray();
		
		swapElementsByIndex(elements,indexes[0],indexes[1]);
		
		elements.forEach(System.out::println);
	
	}
	
	public static <T> void swapElementsByIndex(List<T> list,int index1,int index2){
		
		T element1 = list.get(index1);
		T element2 = list.get(index2);
		list.set(index1,element2);
		list.set(index2,element1);
		
	}
	
	
}


class Box<T> {
	
	private T value;
	
	public Box(T value) {
		this.value = value;
	}
	
	public T getValue() {
		return value;
	}
	
	public void setValue(T value) {
		this.value = value;
	}
	
	@Override
	public String toString() {
		return this.getValue().getClass().getName() + ": "+this.getValue();
	}
}