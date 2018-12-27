package P06_ReverseAndRemove;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] input = reader.readLine().split(" ");

        int divider = Integer.parseInt(reader.readLine());

        List<Integer> numbers = new ArrayList<>();

        for (String s : input) {
            numbers.add(Integer.parseInt(s));
        }

        numbers.removeIf(x -> x % divider == 0);

        Function<List<Integer>, List<Integer>> reverse = n -> {
            for (int i = 0; i < n.size() / 2 ; i++) {
                int temp = n.get(i);
              n.set(i, n.get(n.size() - i - 1));
              n.set(n.size() - i - 1, temp);
            }
            return n;
        };
        reverse.apply(numbers);
        for (Integer number : numbers) {
            System.out.print(number + " ");
        }


    }
}
