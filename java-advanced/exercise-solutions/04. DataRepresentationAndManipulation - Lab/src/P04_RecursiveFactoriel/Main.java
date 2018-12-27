package P04_RecursiveFactoriel;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        System.out.println(fac(n));
    }

    public static int fac(int n) {
        if (n <= 1) {
            return 1;
        }
        return n * fac(n - 1);
    }
}
