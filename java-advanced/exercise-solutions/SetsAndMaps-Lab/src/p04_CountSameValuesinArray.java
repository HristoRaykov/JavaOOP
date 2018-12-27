import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class p04_CountSameValuesinArray {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

       String[] firstLine = scanner.nextLine().split(" ");

        HashMap<String, Integer> map = new HashMap<>();

        for (String i : firstLine) {

            if(!map.containsKey(i)){
                map.put(i, 0);
            }

            map.put(i, map.get(i) + 1);
        }

        for (String key : map.keySet()) {
            System.out.printf("%s - %s times\n", key, map.get(key));
        }
    }
}
