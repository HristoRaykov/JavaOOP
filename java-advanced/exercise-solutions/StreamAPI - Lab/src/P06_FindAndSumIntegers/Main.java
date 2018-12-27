package P06_FindAndSumIntegers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Optional;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

       Optional<Integer> num = Arrays.stream(reader.readLine().split(" "))
               .filter(Main::isNumber)
               .map(Integer::valueOf)
               .reduce((x1, x2) -> x1 + x2);

       if(num.isPresent()){
           System.out.println(num.get());
       }else{
           System.out.println("No match");
       }

    }

    private static boolean isNumber(String input) {
     return input.matches("^\\s*-?[0-9]{1,10}\\s*$");
    }
}
