import java.util.Arrays;
import java.util.Scanner;

public class test {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] size = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        String[][] matrix = new String[size[0]][size[1]];

        for (int row = 0; row < size[0]; row++) {
            String[] input = scanner.nextLine().split(" ");
            for (int col = 0; col < size[1]; col++) {
                matrix[row][col] = input[col];
            }
        }

        for (String[] strings : matrix) {
            for (String string : strings) {
                System.out.print(string + " ");
            }
            System.out.println();
        }
    }
}
