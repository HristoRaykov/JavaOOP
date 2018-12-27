import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class p04_GroupNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] numbers = Arrays.stream(scanner.nextLine().split(", ")).mapToInt(Integer::parseInt).toArray();

        ArrayList<ArrayList<Integer>> matrix = new ArrayList<ArrayList<Integer>>();

        matrix.add(0, new ArrayList<>());
        matrix.add(1, new ArrayList<>());
        matrix.add(1, new ArrayList<>());

        for (int i = 0; i < numbers.length; i++) {

            matrix.get(Math.abs( numbers[i] % 3)).add(numbers[i]);
        }

        for (ArrayList<Integer> integers : matrix) {
            for (Integer integer : integers) {
                System.out.print(integer + " ");
            }
            System.out.println();
        }
    }
}
