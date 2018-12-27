package P07_PredicateForNames;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.function.Predicate;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int countLetters = Integer.parseInt(reader.readLine());
        String[] names = reader.readLine().split(" ");

        Arrays.stream(names).filter(getStringPredicate(countLetters)).forEach(System.out::println);



    }

    private static Predicate<String> getStringPredicate(int countLetters) {
        return x -> x.length() <= countLetters;
    }
}
