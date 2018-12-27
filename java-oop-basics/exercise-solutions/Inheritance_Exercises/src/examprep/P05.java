package examprep;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P05 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(reader.readLine());

        for (int i = 0; i < n ; i++) {
            String line = repeatStr(" ", n) + "~ ~ ~";
            System.out.println(line);
        }

        String middleLine = repeatStr("=", 3 * n + 6 - 1);

        for (int i = 0; i < n; i++) {
            String line = "";
            if(i == 0){
                System.out.println(middleLine);
                continue;
            }else if(i == n - 1){
                System.out.println(middleLine);
                continue;
            }else if(i == n / 2){
                line = "|" + repeatStr("~", n) + "JAVA" + repeatStr("~", n)
                        + "|" + repeatStr(" ", n - 1) + "|";
                System.out.println(line);
                continue;
            }
            line = "|" + repeatStr("~", (n * 3 + 6 - 3) - (n - 1) ) + "|" + repeatStr(" ", n - 1) + "|";
            System.out.println(line);
        }

        for (int i = 0; i < n; i++) {
            String line = repeatStr(" ", i) + "\\" + repeatStr("@", (n * 3 + 6 - 3 - (n - 1)) - 2 * i) + "/";
            System.out.println(line);
        }
        System.out.println(repeatStr("=", n * 3 + 6 - n));

    }static String repeatStr(String strToRepeat, int count){
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < count; i++) {
            sb.append(strToRepeat);
        }
        return sb.toString();
    }
}
