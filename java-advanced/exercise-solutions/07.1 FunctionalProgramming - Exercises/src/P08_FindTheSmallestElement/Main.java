package P08_FindTheSmallestElement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        List<Integer> numbers = Arrays.stream(reader.readLine().split("\\s+")).map(Integer::valueOf).collect(Collectors.toList());

        Function<List<Integer>, Integer> filter = nums -> {
            return  nums.lastIndexOf(nums.stream().mapToInt(Integer::intValue).min().getAsInt());
        };

        System.out.println(filter.apply(numbers));
    }
}
