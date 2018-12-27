import java.util.Scanner;

/**
 * Created by User on 22.8.2017 г..
 */
public class p08_HitTheTarget {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        int num = scanner.nextInt();

        for (int i = 1; i <= 20; i++) {
            for (int j = 1; j <= 20 ; j++) {

                if(i + j == num){
                    System.out.printf("%d + %d = %d\n", i, j, num);
                }
            }
        }
        for (int i = 1; i <= 20; i++) {
            for (int j = 1; j <= 20 ; j++) {

                if(i - j == num){
                    System.out.printf("%d - %d = %d\n", i, j, num);
                }
            }
        }
    }
}
