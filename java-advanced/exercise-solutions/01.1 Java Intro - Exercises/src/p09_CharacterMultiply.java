import java.util.Scanner;

/**
 * Created by User on 22.8.2017 г..
 */
public class p09_CharacterMultiply {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String a = scanner.next();
        String b = scanner.next();

        if(a.length() == b.length()){

            int sum = 0;

            for (int i = 0; i < a.length(); i++) {

                sum += a.charAt(i) * b.charAt(i);
            }
            System.out.println(sum);
            return;
        }

        int minLength = Math.min(a.length(), b.length());

        int sum = 0;

        for (int i = 0; i < minLength; i++) {
            sum += a.charAt(i) * b.charAt(i);
        }

        if(a.length() == minLength){
            for (int i = minLength; i < b.length() ; i++) {
                sum += b.charAt(i);
            }
        }else if(b.length() == minLength){
            for (int i = minLength; i < a.length() ; i++) {
                sum += a.charAt(i);
            }
        }

        System.out.println(sum);
    }
}
