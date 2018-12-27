package P04_UnicodeCharacters;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        char[] text = scanner.nextLine().toCharArray();

        StringBuilder sb = new StringBuilder();

        for (char c : text) {
            sb.append( "\\u").append(Integer.toHexString(c | 0x10000).substring(1));
        }

        System.out.println(sb);
    }
}
