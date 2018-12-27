package P01_Sorting;

import java.util.Arrays;
import java.util.Scanner;

public class BubbleSort {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] numbers = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        boolean swapped;
        do {
            swapped = false;
            for (int index = 0; index < numbers.length - 1; index++) {
                if (numbers[index] > numbers[index + 1]) {
                    swap(numbers, index);
                    swapped = true;
                }
            }
        } while (swapped);

        System.out.println(Arrays.toString(numbers).replace("[", "").replace("]", "").replace(",", ""));
    }
    private static void swap(int[] numbers, int index) {
        int temp = numbers[index];
        numbers[index] = numbers[index + 1];
        numbers[index + 1] = temp;
    }
}
