import java.util.Scanner;
import java.util.TreeSet;

public class p02_Party {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        TreeSet<String> regular = new TreeSet<>();
        TreeSet<String> vip = new TreeSet<>();

        while (true) {
            String input = scanner.nextLine();

            if (input.equals("PARTY")) {
                break;
            }
            try {
                int first = Integer.parseInt(String.valueOf(input.charAt(0)));
                vip.add(input);
            } catch (Exception ex) {
                regular.add(input);
            }
        }
        while (true) {
            String input = scanner.nextLine();
            if (input.equals("END")) {
                break;
            }

            try {
                int first = Integer.parseInt(String.valueOf(input.charAt(0)));

                if(vip.contains(input)){
                    vip.remove(input);
                }
            } catch (Exception ex) {
                if(regular.contains(input)){
                    regular.remove(input);
                }
            }
        }
        System.out.println(vip.size() + regular.size());
        for (String vips : vip) {
            System.out.println(vips);
        }
        for (String s : regular) {
            System.out.println(s);
        }

    }
}
