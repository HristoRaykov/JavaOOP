import java.util.Scanner;

/**
 * Created by User on 21.8.2017 г..
 */
public class p02_TriangleArea {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int ax = scanner.nextInt();
        int ay = scanner.nextInt();
        int bx = scanner.nextInt();
        int by = scanner.nextInt();
        int cx = scanner.nextInt();
        int cy = scanner.nextInt();

        int triangleArea = (Math.abs((ax * (by - cy) + bx * (cy - ay) + cx * (ay - by)) / 2));

        System.out.println(triangleArea);
    }
}
