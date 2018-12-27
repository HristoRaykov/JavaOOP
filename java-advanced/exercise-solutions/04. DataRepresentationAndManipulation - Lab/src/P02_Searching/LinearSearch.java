package P02_Searching;

import java.util.Arrays;
import java.util.Scanner;

public class LinearSearch {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] numbers = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int num = Integer.parseInt(scanner.nextLine());

        System.out.println(linearSearch(numbers, num));

    }

    private static int linearSearch(int[] numbers, int num) {
        for (int i = 0; i < numbers.length; i++) {
            if(numbers[i] == num){
                return i;
            }
        }
        return - 1;
    }
}
