import java.util.ArrayDeque;
import java.util.Scanner;

public class p05_CalculcateSequence {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        long n = Long.parseLong(scanner.nextLine());

        ArrayDeque<Long> queue = new ArrayDeque<>();

        queue.offer(n);

        for (int i = 0; i < 50; i++) {

            long s1 = queue.poll();

            System.out.printf("%d ", s1);

            long s2 = s1 + 1;
            long s3 = 2 * s1 + 1;
            long s4 = s1 + 2;

            queue.add(s2);
            queue.add(s3);
            queue.add(s4);

        }
    }
}
