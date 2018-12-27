package P16_DragonArmy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(reader.readLine());

        Map<String, List<Dragon>> dragons = new LinkedHashMap<>();

        while (n-- > 0){
            String[] line = reader.readLine().split(" ");
            String type = line[0];
            String name = line[1];
            String damage = line[2];
            String health = line[3];
            String armor = line[4];

            Dragon dragon = new Dragon(name, damage, health, armor);

            dragons.putIfAbsent(type, new LinkedList<>());
            dragons.get(type).add(dragon);
        }

        Map<String, String> resultsByType = new TreeMap<>();


        for (Map.Entry<String, List<Dragon>> entry : dragons.entrySet()) {
                String name = entry.getKey();

                double damage = 0;
                double health = 0;
                double armor = 0;
                for (int i = 0; i < entry.getValue().size(); i++) {

                    Dragon currentDragon = entry.getValue().get(i);
                    damage += currentDragon.getDamage();
                    health += currentDragon.getHealth();
                    armor += currentDragon.getArmor();
                }
            damage = damage / entry.getValue().size();
            health = health / entry.getValue().size();
            armor = armor / entry.getValue().size();

            String result = String.format("%s::(%.2f/%.2f/%.2f)%n", name, damage,health,armor);
            resultsByType.put(name, result);
        }

        for (Map.Entry<String, String> stringStringEntry : resultsByType.entrySet()) {
            System.out.print(stringStringEntry.getValue());

            for (Map.Entry<String, List<Dragon>> entry : dragons.entrySet()) {
                for (int i = 0; i < entry.getValue().size(); i++) {
                    if(stringStringEntry.getKey().equals(entry.getKey())){
                        Dragon currentDragon = entry.getValue().get(i);

                        String name = currentDragon.getName();
                        int damage = currentDragon.getDamage();
                        int health = currentDragon.getHealth();
                        int armor = currentDragon.getArmor();

                        String line = String.format("-%s -> damage: %d, health: %d, armor: %d", name, damage, health, armor);
                        System.out.println(line);
                    }
                }
            }
        }

    }
}
