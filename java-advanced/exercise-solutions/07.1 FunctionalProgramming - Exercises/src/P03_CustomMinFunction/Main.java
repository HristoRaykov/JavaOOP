package P03_CustomMinFunction;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.function.Function;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] input = (reader.readLine().split("\\s+"));

        Integer[] numbers = new Integer[input.length];

        for (int i = 0; i < input.length; i++) {
            numbers[i] = Integer.parseInt(input[i]);
        }

        System.out.println(findMinElement.apply(numbers));

    }private static Function<Integer[], Integer> findMinElement = new Function<Integer[], Integer>() {
        @Override
        public Integer apply(Integer[] ints) {
            Integer minNum = ints[0];
            for (int anInt : ints) {
                if(minNum > anInt){
                    minNum = anInt;
                }
            }
            return minNum;
        }
    };
}
