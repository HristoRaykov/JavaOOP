package examprep;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P03 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        double weight = Double.parseDouble(reader.readLine());
        String type = reader.readLine();
        double distance = Double.parseDouble(reader.readLine());

        double cost = 0;
        double express = 0;

        if (weight < 1) {
            cost = 0.03;
            if (type.equals("express")) {
                express = cost * 0.8;
            }
        } else if (weight < 10) {
            cost = 0.05;
            if (type.equals("express")) {
                //cost = cost * 1.4;
                express = cost * 0.4;
            }
        } else if (weight < 40) {
            cost = 0.10;
            if (type.equals("express")) {
                // cost = cost * 1.05;
                express = cost * 0.05 ;
            }
        } else if (weight < 90) {
            cost = 0.15;
            if (type.equals("express")) {
                //cost = cost * 1.02;
                express = cost * 0.02;

            }
        } else if (weight < 150) {
            cost = 0.2;
            if (type.equals("express")) {
                // cost = cost * 1.01;
                express = cost * 0.01;
            }
        }
        double totalPrice = 0;

        if (type.equals("express")) {
            totalPrice = (cost * distance) + (weight * express * distance);

        } else {
            totalPrice = (cost * distance);
        }
        System.out.printf("The delivery of your shipment with weight of %.3f kg. ", weight);
        System.out.printf("would cost %.2f lv.", totalPrice);
    }
}
