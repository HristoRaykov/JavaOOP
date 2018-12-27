package P03_FirstName;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        List<String> input = Arrays.stream(reader.readLine().split(" ")).collect(Collectors.toList());
        Set<String> letters = Arrays.stream(reader.readLine()
                .split(" "))
                .map(String::toLowerCase)
                .collect(Collectors.toSet());

        Optional<String> name = input.stream()
                .filter(s -> letters.contains(String.valueOf(s.toLowerCase().charAt(0))))
                .sorted()
                .findFirst();

        if(name.isPresent()){
            System.out.println(name.get());
        }else{
            System.out.println("No match");
        }
    }
}
