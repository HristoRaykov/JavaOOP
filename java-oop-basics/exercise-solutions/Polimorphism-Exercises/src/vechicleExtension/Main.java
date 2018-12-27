package vechicleExtension;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DecimalFormat;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] carArgs = reader.readLine().split(" ");
        String[] truckArgs = reader.readLine().split(" ");
        String[] busArgs = reader.readLine().split(" ");

        Vehicle car = new Car(Double.parseDouble(carArgs[1]), Double.parseDouble(carArgs[2]), Double.parseDouble(carArgs[3]));
        Vehicle truck = new Truck(Double.parseDouble(truckArgs[1]), Double.parseDouble(truckArgs[2]), Double.parseDouble(truckArgs[3]));
        Vehicle bus = new Bus(Double.parseDouble(busArgs[1]), Double.parseDouble(busArgs[2]), Double.parseDouble(busArgs[3]));

        int n = Integer.parseInt(reader.readLine());

        DecimalFormat df = new DecimalFormat("#.##");

        while (n-- > 0) {
            String[] line = reader.readLine().split(" ");
            switch (line[0]) {
                case "Drive":
                    if ("Car".equals(line[1])) {
                        try {
                            car.drive(Double.parseDouble(line[2]));
                            System.out.printf("Car travelled %s km%n", df.format(Double.parseDouble(line[2])));
                        } catch (IllegalArgumentException error) {
                            System.out.println(error.getMessage());
                        }
                    } else if ("Truck".equals(line[1])) {
                        try {
                            truck.drive(Double.parseDouble(line[2]));
                            System.out.printf("Truck travelled %s km%n", df.format(Double.parseDouble(line[2])));
                        } catch (IllegalArgumentException error) {
                            System.out.println(error.getMessage());
                        }
                    } else {
                        try {
                            bus.setConsumption(bus.getConsumption() + 1.4);
                            bus.drive(Double.parseDouble(line[2]));
                            System.out.printf("Bus travelled %s km%n", df.format(Double.parseDouble(line[2])));
                            bus.setConsumption(bus.getConsumption() - 1.4);
                        } catch (IllegalArgumentException error) {
                            System.out.println(error.getMessage());
                            bus.setConsumption(bus.getConsumption() - 1.4);
                        }
                    }
                    break;
                case "DriveEmpty":
                    try {
                        bus.drive(Double.parseDouble(line[2]));
                        System.out.printf("Bus travelled %s km%n", df.format(Double.parseDouble(line[2])));
                    } catch (IllegalArgumentException error) {
                        System.out.println(error.getMessage());
                    }
                    break;
                case "Refuel":
                    if ("Car".equals(line[1])) {
                        try {
                            car.refuel(Double.parseDouble(line[2]));
                        }catch (IllegalArgumentException ex){
                            System.out.println(ex.getMessage());
                        }
                    } else if ("Truck".equals(line[1])) {
                        try {
                            truck.refuel(Double.parseDouble(line[2]));
                        }catch (IllegalArgumentException ex){
                            System.out.println(ex.getMessage());
                        }
                    } else {
                        try {
                            bus.refuel(Double.parseDouble(line[2]));
                        }catch (IllegalArgumentException ex){
                            System.out.println(ex.getMessage());
                        }
                    }
                    break;
            }
        }

        System.out.printf("Car: %.2f%n", car.getFuel());
        System.out.printf("Truck: %.2f%n", truck.getFuel());
        System.out.printf("Bus: %.2f%n", bus.getFuel());
    }
}
