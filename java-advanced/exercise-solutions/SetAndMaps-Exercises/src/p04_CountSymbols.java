import java.util.Scanner;
import java.util.TreeMap;

public class p04_CountSymbols {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        TreeMap<String, Integer> symbols = new TreeMap<>();

        for (int i = 0; i < input.length(); i++) {

            String currentSymb = String.valueOf(input.charAt(i));

            if(!symbols.containsKey(currentSymb)){
                symbols.put(currentSymb, 1);
            }else{
                symbols.put(currentSymb, symbols.get(currentSymb) + 1);
            }
        }

        for (String s : symbols.keySet()) {
            System.out.printf("%s: %d time/s\n", s, symbols.get(s));
        }
    }
}
