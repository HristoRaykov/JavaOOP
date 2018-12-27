import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Scanner;

public class p05_HotPotato {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split(" ");
        int n = Integer.parseInt(scanner.nextLine());

        ArrayDeque<String> players = new ArrayDeque<>();

        Collections.addAll(players, input);

        while(players.size() > 1){
            for (int i = 1; i < n ; i++) {
                players.offer(players.poll());
            }
            System.out.println("Removed " + players.poll());
        }

        System.out.println("Last is " + players.poll());
    }
}
