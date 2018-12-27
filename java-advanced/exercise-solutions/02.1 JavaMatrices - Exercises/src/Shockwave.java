import java.util.Scanner;

public class Shockwave {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] size = scanner.nextLine().split(" ");

        int rows = Integer.parseInt(size[0]);
        int cols = Integer.parseInt(size[1]);

        int[][] matrix = new int[rows][cols];

        while (true) {

            String[] input = scanner.nextLine().split(" ");

            if (input[0].equals("Here")) {
                break;
            }

            int x1 = Integer.parseInt(input[0]);
            int y1 = Integer.parseInt(input[1]);
            int x2 = Integer.parseInt(input[2]);
            int y2 = Integer.parseInt(input[3]);

            try {
                for (int row = x1; row <= x2; row++) {
                    for (int col = y1; col <= y2; col++) {
                        matrix[row][col] += 1;
                    }
                }

            } catch (Exception ex) {
                continue;
            }
        }

        for (int[] ints : matrix) {
            for (int anInt : ints) {
                System.out.print(anInt + " ");
            }
            System.out.println();
        }
    }
}
