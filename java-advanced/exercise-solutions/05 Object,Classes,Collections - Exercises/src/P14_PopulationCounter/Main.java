package P14_PopulationCounter;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        HashMap<String, HashMap<String, Long>> populationStore = new HashMap<>();

        String[] input = reader.readLine().split("\\|");

        while (!input[0].equals("report")) {

            String country = input[1];
            String city = input[0];
            Long population = Long.parseLong(input[2]);

            populationStore.putIfAbsent(country, new LinkedHashMap<>());
            populationStore.get(country).putIfAbsent(city, population);

            input = reader.readLine().split("\\|");
        }

        LinkedHashMap<String, Long> result = new LinkedHashMap<>();

        for (String s : populationStore.keySet()) {
            LinkedHashMap<String, Long> sorted = populationStore.get(s).entrySet().stream()
                    .sorted(Map.Entry.comparingByValue(Collections.reverseOrder()))
                    .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));

            Long totalPopulation = 0L;
            String towns = "";
            for (String s1 : sorted.keySet()) {
                Long townPop = populationStore.get(s).get(s1);
                totalPopulation += townPop;
                towns += "=>" + s1 + ": " + townPop + "\n";
            }
            towns = s + " (total population: " + totalPopulation + ")" + "\n" + towns.substring(0, towns.length() - 1);
            result.put(towns, totalPopulation);

        }
        LinkedHashMap<String, Long> sorted = result.entrySet().stream()
                .sorted(Map.Entry.comparingByValue(Collections.reverseOrder()))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));

        for (String s : sorted.keySet()) {
            System.out.println(s);
        }
    }
}
