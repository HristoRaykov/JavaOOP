package P03_TextFilter;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] bannedWord = scanner.nextLine().split(", ");
        String text = scanner.nextLine();

        for (int i = 0; i < bannedWord.length ; i++) {
            String currentWord = bannedWord[i];

            while(text.contains(currentWord)){

               text = text.replace(currentWord, repeatStr(currentWord.length()));
            }
        }
        System.out.println(text);
    }
    public static StringBuilder repeatStr(int count){
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < count; i++) {
            sb.append("*");
        }
        return sb;
    }
}
