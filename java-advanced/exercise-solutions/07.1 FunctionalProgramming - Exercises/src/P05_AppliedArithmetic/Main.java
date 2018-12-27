package P05_AppliedArithmetic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.function.Function;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        long[] numbers = Arrays.stream(reader.readLine().split(" ")).mapToLong(Long::parseLong).toArray();
        String command = reader.readLine();

        while (!command.equals("end")) {
            if("print".equals(command)){
                for (long number : numbers) {
                    System.out.print(number + " ");
                }
                System.out.println();
                command = reader.readLine();
                continue;
            }
            for (int i = 0; i < numbers.length; i++) {
               numbers[i] = getManipulation(command).apply(numbers[i]);
            }
            command = reader.readLine();

        }


    }

    public static Function<Long, Long> getManipulation(String command) {
        switch (command) {
            case "add":
                return x -> x + 1;
            case "multiply": return x -> x * 2;
            case "subtract": return x -> x - 1;
        }
        return null;
    }
}
