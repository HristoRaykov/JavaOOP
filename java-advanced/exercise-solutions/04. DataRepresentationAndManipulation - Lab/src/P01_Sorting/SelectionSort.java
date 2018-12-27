package P01_Sorting;

import java.util.Arrays;
import java.util.Scanner;

public class SelectionSort {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] numbers = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        for (int index = 0; index < numbers.length; index++) {
            int min = index;
            for (int current = index + 1; current < numbers.length; current++) {
                if (numbers[current] < numbers[min]) {
                    min = current;
                }
            }
            swap(numbers, index, min);

        }
    }

    private static void swap(int[] numbers, int index, int min) {
        int temp = numbers[index];
        numbers[index] = numbers[min];
        numbers[min] = temp;
    }
}
