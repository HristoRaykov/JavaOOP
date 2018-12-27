package p01_ReadInput;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String firstWord = scanner.next("\\w+");
        String secondWord = scanner.next("\\w+");
        int num1 = scanner.nextInt();
        int num2 = scanner.nextInt();
        int num3 = scanner.nextInt();
        scanner.nextLine();
        String thirdWord = scanner.nextLine();

        System.out.printf("%s %s %s %s", firstWord, secondWord, thirdWord, num1 + num2 + num3);

    }
}
