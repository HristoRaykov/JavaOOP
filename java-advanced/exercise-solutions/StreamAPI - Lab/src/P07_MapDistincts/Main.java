package P07_MapDistincts;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] input = reader.readLine().split(" ");

        HashMap<String, List<Integer>> cities = new HashMap<>();

        for (int i = 0; i < input.length; i++) {
            String[] tokens = input[i].split(":");
            cities.putIfAbsent(tokens[0], new ArrayList<>());
            cities.get(tokens[0]).add(Integer.parseInt(tokens[1]));
        }

        int population = Integer.parseInt(reader.readLine());

        cities.entrySet().stream()
                .filter(removeCitiesWithLessPopulation(population))
                .sorted(sortCitiesByTotalPopulation())
                .forEach(printMapEntryConsumer());
    }

    private static Consumer<? super Map.Entry<String, List<Integer>>> printMapEntryConsumer() {
        return kv -> {
            System.out.print(kv.getKey() + ": ");
            kv.getValue().stream().sorted((s1, s2) -> s2.compareTo(s1)).limit(5).forEach(dp -> System.out.print(dp + " "));
            System.out.println();
        };
    }

    private static Comparator<? super Map.Entry<String, List<Integer>>> sortCitiesByTotalPopulation() {
        return (kv1, kv2) ->
                Integer.compare(
                kv2.getValue().stream().mapToInt(Integer::valueOf).sum(),
                kv1.getValue().stream().mapToInt(Integer::valueOf).sum());
    }

    private static Predicate<? super Map.Entry<String, List<Integer>>> removeCitiesWithLessPopulation(int population) {
        return kv -> kv.getValue().stream().mapToInt(Integer::valueOf).sum() >= population;
    }
}
