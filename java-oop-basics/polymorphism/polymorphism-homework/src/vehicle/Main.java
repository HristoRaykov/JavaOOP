package vehicle;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DecimalFormat;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] carArgs = reader.readLine().split(" ");
        String[] truckArgs = reader.readLine().split(" ");

        Vehicle car = new Car(Double.parseDouble(carArgs[1]), Double.parseDouble(carArgs[2]));
        Vehicle truck = new Truck(Double.parseDouble(truckArgs[1]), Double.parseDouble(truckArgs[2]));

        int n = Integer.parseInt(reader.readLine());

        DecimalFormat df = new DecimalFormat("#.##");

        while (n-- > 0){
            String[] line = reader.readLine().split(" ");
            switch (line[0]){
                case "Drive":
                    if("Car".equals(line[1])){
                       try {
                           car.drive(Double.parseDouble(line[2]));
                           System.out.printf("Car travelled %s km%n", df.format(Double.parseDouble(line[2])));
                       }catch (IllegalArgumentException error){
                           System.out.println(error.getMessage());
                       }
                    }else{
                        try {
                            truck.drive(Double.parseDouble(line[2]));
                            System.out.printf("Truck travelled %s km%n", df.format(Double.parseDouble(line[2])));
                        }catch (IllegalArgumentException error){
                            System.out.println(error.getMessage());
                        }
                    }
                    break;
                case "Refuel":
                    if("Car".equals(line[1])){
                        car.refuel(Double.parseDouble(line[2]));
                    }else{
                        truck.refuel(Double.parseDouble(line[2]));
                    }
                    break;
            }
        }

        System.out.printf("Car: %.2f%n", car.getFuel());
        System.out.printf("Truck: %.2f%n", truck.getFuel());

    }
}
