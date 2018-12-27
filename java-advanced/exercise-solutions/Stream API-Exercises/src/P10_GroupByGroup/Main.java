package P10_GroupByGroup;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String line = reader.readLine();

        HashMap<String, List<String>> persons = new HashMap<>();

        while (!"END".equals(line)) {

            String[] data = line.split(" ");

            persons.putIfAbsent(data[2], new ArrayList<>(0));
            persons.get(data[2]).add(data[0] + " " + data[1]);

            line = reader.readLine();
        }

        persons.entrySet().forEach(x -> {
            System.out.print(x.getKey() + " - ");
            System.out.print(String.join(", ", x.getValue()).replaceAll("[\\[\\]]", "") + "\n");
        });
    }
}
