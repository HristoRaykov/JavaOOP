import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Stream;

public class p02_SumMatrixElements {
    public static  void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] size = Arrays.stream(scanner.nextLine().split(", ")).mapToInt(Integer::parseInt).toArray();

        int[][] matrice = new int[size[0]][size[1]];

        int sum = 0;

        for (int row = 0; row < matrice.length; row++) {

            String[] reminder = scanner.nextLine().split(", ");

            sum += Stream.of(reminder).mapToInt(Integer::parseInt).sum();

            for (int col = row; col < matrice[0].length; col++) {
                matrice[row][col] = Integer.parseInt(reminder[col]);
            }
        }
        System.out.println(size[0]);
        System.out.println(size[1]);
        System.out.println(sum);

    }
}
