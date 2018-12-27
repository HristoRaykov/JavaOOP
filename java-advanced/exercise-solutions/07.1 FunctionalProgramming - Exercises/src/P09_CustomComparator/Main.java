package P09_CustomComparator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int range = Integer.parseInt(reader.readLine());
        List<Integer> deviders = Arrays.stream(reader.readLine().split(" ")).map(Integer::valueOf).collect(Collectors.toList());

        for (int i = 1; i <= range ; i++) {
            boolean isDevidable = true;

            for (int j = 0; j < deviders.size() ; j++) {
                int currentDecider = deviders.get(j);

                Predicate<Integer> check = x -> x % currentDecider == 0;

                if(!check.test(i)){
                    isDevidable = false;
                    break;
                }
            }
            if(isDevidable){
                System.out.print(i + " ");
            }
        }
    }
}
