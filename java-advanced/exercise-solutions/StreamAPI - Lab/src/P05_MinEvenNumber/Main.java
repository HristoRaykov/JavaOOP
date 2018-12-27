package P05_MinEvenNumber;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Optional;
import java.util.OptionalDouble;
import java.util.OptionalInt;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] input = reader.readLine().split(" ");

        OptionalDouble result =  Arrays.stream(input).filter(x -> x.length() > 0).mapToDouble(Double::valueOf).filter(x -> x % 2 == 0).min();

       if(result.isPresent()){
           System.out.printf("%.2f", result.getAsDouble());
       }else{
           System.out.println("No match");
       }
    }
}
