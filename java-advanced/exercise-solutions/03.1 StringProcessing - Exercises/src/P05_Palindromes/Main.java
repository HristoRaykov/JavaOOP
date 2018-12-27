package P05_Palindromes;

import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split("[,.\\s+?!]+");

        Set<String> result = new TreeSet<>();

        for (String s : input) {
            StringBuilder sb = new StringBuilder(s);
            if(sb.reverse().toString().equals(s)){
                result.add(s);
            }
        }
        System.out.println(result);
    }
}
