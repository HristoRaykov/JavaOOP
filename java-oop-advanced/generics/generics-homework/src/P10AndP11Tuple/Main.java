package P10AndP11Tuple;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
	
	
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		String[] input = null;
		List<Threeuple> tuples = new ArrayList<>();
//		Tuple tuple = null;
		Threeuple tuple = null;
		
		input = reader.readLine().split("\\s+");
		String name = input[0]+ " "+input[1];
//		tuple=new Tuple(name,input[2]);
		tuple = new Threeuple<>(name,input[2],input[3]);
		tuples.add(tuple);
		
		input = reader.readLine().split("\\s+");
//		tuple=new Tuple(input[0],Integer.valueOf(input[1]));
		tuple = new Threeuple<>(input[0],Integer.valueOf(input[1]), input[2].equals("drunk"));
		tuples.add(tuple);
		
		input = reader.readLine().split("\\s+");
//		tuple=new Tuple(Integer.valueOf(input[0]),Double.valueOf(input[1]));
		tuple = new Threeuple<>(input[0],Double.valueOf(input[1]), input[2]);
		tuples.add(tuple);
		
		tuples.forEach(System.out::println);
	
	}
}
