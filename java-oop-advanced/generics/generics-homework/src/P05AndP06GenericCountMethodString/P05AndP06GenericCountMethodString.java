package P05AndP06GenericCountMethodString;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class P05AndP06GenericCountMethodString {
	
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		List<Box<Double>> elements = new ArrayList<>();
		
		int n = Integer.valueOf(reader.readLine());
		for (int i = 0; i < n; i++) {
			elements.add(new Box<>(Double.valueOf(reader.readLine())));
		}
		
		Box<Double> box = new Box<>(Double.valueOf(reader.readLine()));
		
		int count = countElementsGreaterThan(elements, box);
		
		System.out.println(count);
		
	}
	
	public static <T extends Comparable<T>> int countElementsGreaterThan(List<T> list, T element){
		int counter=0;
		for (T t : list) {
			if (t.compareTo(element)>0){
				counter++;
			}
		}
		
		return counter;
	}
	
	
	
}


class Box<T extends Comparable<T>> implements Comparable<Box<T>>{
	
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
	
	
	@Override
	public int compareTo(Box<T> box) {
		return this.value.compareTo(box.value);
	}
}