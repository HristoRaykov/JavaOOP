package P06_MagicExchengableWords;

import java.util.LinkedHashSet;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String first = scanner.next();
        String second = scanner.next();

        LinkedHashSet<String> firstWordChard = new LinkedHashSet<>();
        LinkedHashSet<String> secondWordChard = new LinkedHashSet<>();

        for (int i = 0; i < first.length(); i++) {
            firstWordChard.add(first.charAt(i)+"");
        }
        for (int i = 0; i < second.length(); i++) {
            secondWordChard.add(second.charAt(i)+"");
        }
        if (firstWordChard.size() == secondWordChard.size()){
            System.out.println(true);
        }else{
            System.out.println(false);
        }
    }
}
