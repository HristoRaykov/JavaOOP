package P04_EvensOrOdds;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.function.Predicate;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int[] range = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        String command = reader.readLine();

        getNumbers(range, command);

    }
    private static void getNumbers(int[] range, String command) {
        for (int i = range[0]; i <= range[1]; i++) {
            Predicate<Integer> evenOrOdd = getEvenOrOdd(command, i);
            if(evenOrOdd.test(i)){
                System.out.print(i + " ");
            }
        }
    }

    private static Predicate<Integer> getEvenOrOdd(String command, int i) {
        switch (command){
            case "even": return x -> x % 2 == 0;
            case "odd": return x -> x % 2 != 0;
            default: return null;
        }
    }
}
