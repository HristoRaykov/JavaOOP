import java.util.Arrays;
import java.util.Scanner;

public class p04_2x2SquaresInMatrix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] size = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        String[][] matrix = new String[size[0]][size[1]];

        for (int row = 0; row < size[0]; row++) {
            String[] input = scanner.nextLine().split(" ");
            for (int col = 0; col < size[1]; col++) {
                matrix[row][col] = String.valueOf(input[col]);
            }
        }
        int count = 0;

        for (int row = 0; row < size[0] - 1; row++) {
            for (int col = 0; col < size[1] - 1; col++) {

                if ((matrix[row][col].equals(matrix[row][col + 1])) &&
                        (matrix[row + 1][col].equals(matrix[row + 1][col + 1])) &&
                        matrix[row][col].equals(matrix[row + 1][col + 1])) {

                    count++;
                }
            }
        }

        System.out.println(count);
    }
}
