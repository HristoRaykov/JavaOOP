import java.util.Scanner;

public class XBits {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] binary = new String[8];

        for (int i = 0; i < 8; i++) {
            String input = String.format("%32s", Integer.toBinaryString(Integer.parseInt(scanner.nextLine())))
                    .replace(" ", "0");
            binary[i] = input;
        }
        int count = 0;
        for (int r = 0; r < binary.length - 2; r++) {
            for (int c = 0; c < binary[r].length() - 2; c++) {
                String a = binary[r].charAt(c) + "" + binary[r].charAt(c + 1) + binary[r].charAt(c + 2);
                String b = binary[r + 1].charAt(c) + "" + binary[r + 1].charAt(c + 1) + binary[r + 1].charAt(c + 2);
                String d = binary[r + 2].charAt(c) + "" + binary[r + 2].charAt(c + 1) + binary[r + 2].charAt(c + 2);

                if (a.equals("101") && b.equals("010") & d.equals("101")) {
                    count++;
                }
            }
        }
        System.out.println(count);

    }
}
