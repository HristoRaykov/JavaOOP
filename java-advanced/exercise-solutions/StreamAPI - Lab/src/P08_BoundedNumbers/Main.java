package P08_BoundedNumbers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int[] bounds = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).sorted().limit(2).toArray();

        List<Integer> numbers = Arrays.stream(reader.readLine().split(" ")).map(Integer::valueOf).collect(Collectors.toList());

        numbers.stream().filter(x -> x >= bounds[0] && x<= bounds[1]).forEach(x -> System.out.print(x + " "));
    }
}
