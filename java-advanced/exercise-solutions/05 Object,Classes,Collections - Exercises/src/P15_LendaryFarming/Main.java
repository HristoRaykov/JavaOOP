package P15_LendaryFarming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);

        Map<String, Integer> materials = new TreeMap<>();
        Map<String, Integer> inventory = new TreeMap<>();

        inventory.put("motes", 0);
        inventory.put("fragments", 0);
        inventory.put("shards", 0);

        materials.put("motes", 0);
        materials.put("fragments", 0);
        materials.put("shards", 0);

        for (int j = 0; j <= 10; j++) {

            String[] line = scanner.nextLine().split(" ");

            for (int i = 0; i < line.length; i += 2) {
                int quantity = Integer.parseInt(line[i]);
                String material = line[i + 1].toLowerCase();

                if (materials.get("motes") >= 250
                        || materials.get("fragments") >= 250
                        || materials.get("shards") >= 250) {
                    break;
                }

                if (material.equals("motes") || material.equals("fragments") || material.equals("shards")) {
                    inventory.put(material, inventory.get(material) + quantity);
                }
                materials.putIfAbsent(material, 0);
                materials.put(material, materials.get(material) + quantity);
            }
            if (materials.containsKey("shards") && materials.get("shards") >= 250) {
                System.out.println("Shadowmourne obtained!");
                inventory.put("shards", inventory.get("shards") - 250);
                break;

            } else if (materials.containsKey("fragments") && materials.get("fragments") >= 250) {
                System.out.println("Valanyr obtained!");
                inventory.put("fragments", inventory.get("fragments") - 250);
                break;

            } else if (materials.containsKey("motes") && materials.get("motes") >= 250) {
                System.out.println("Dragonwrath obtained!");
                inventory.put("motes", inventory.get("motes") - 250);
                break;

            }
        }
        Comparator<Map.Entry<String, Integer>> byQuantity = Comparator.comparing(Map.Entry::getValue, Comparator.reverseOrder());
        Comparator<Map.Entry<String, Integer>> byAlphabetical = Comparator.comparing(Map.Entry::getKey);
        Map<String, Integer> keyMaterials = inventory.entrySet().stream()
                .filter(kvp -> kvp.getKey().equals("shards") || kvp.getKey().equals("fragments") || kvp.getKey().equals("motes"))
                .sorted(byQuantity.thenComparing(byAlphabetical))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));

        for (String s : keyMaterials.keySet()) {
            System.out.printf("%s: %d%n", s, keyMaterials.get(s));
        }
        materials.remove("motes");
        materials.remove("fragments");
        materials.remove("shards");

        for (String s : materials.keySet()) {
            System.out.printf("%s: %d%n", s, materials.get(s));

        }

    }
}
