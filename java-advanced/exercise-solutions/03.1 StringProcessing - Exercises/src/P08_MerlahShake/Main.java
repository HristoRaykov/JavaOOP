package P08_MerlahShake;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

       StringBuilder sb = new StringBuilder(scanner.nextLine());
        String key = scanner.nextLine();

        while(true){

            int lastIndex = sb.lastIndexOf(key);
            int firstIndex = sb.indexOf(key);

            if((lastIndex == -1 || firstIndex == -1) || key.length() == 0){
                System.out.println("No shake.");
                System.out.println(sb);
                break;
            }

            sb = sb.replace(firstIndex, firstIndex + key.length(), "");
            sb = sb.replace(lastIndex - key.length(), lastIndex, "");
            System.out.println("Shaked it.");

            int index = key.length() / 2;
            key = key.substring(0, index) + key.substring(index + 1);

        }
    }
}
