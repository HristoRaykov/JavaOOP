import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Created by User on 23.8.2017 г..
 */
public class p11_GameOfNames {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int count = Integer.parseInt(scanner.nextLine());

        Map<String, Integer> players = new HashMap<String, Integer>();


        for (int i = 0; i < count; i++) {

            String name = scanner.nextLine();
            int points = Integer.parseInt(scanner.nextLine());

            for (int j = 0; j < name.length(); j++) {

                int letterCode = (int) (name.charAt(j));

                if(letterCode % 2 == 0){
                    points += letterCode;
                }else{
                    points -= letterCode;
                }
            }

            players.put(name, points);
        }

        String name = "";
        int points = Integer.MIN_VALUE;

        for (Map.Entry<String, Integer> stringIntegerEntry : players.entrySet()) {

            if(stringIntegerEntry.getValue() > points){
                name = stringIntegerEntry.getKey();
                points = stringIntegerEntry.getValue();
            }
        };

        System.out.printf("The winner is %s - %d points", name, points);
    }
}
