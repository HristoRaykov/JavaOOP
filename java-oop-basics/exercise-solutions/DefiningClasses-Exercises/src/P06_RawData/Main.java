package P06_RawData;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        List<Car> cars = new ArrayList<>();

        while (n-- > 0) {
            String[] commandArgs = scanner.nextLine().split(" ");
            String model = commandArgs[0];
            Car car = null;
            int engineSpeed = Integer.parseInt(commandArgs[1]);
            int enginePower = Integer.parseInt(commandArgs[2]);
            Engine engine = new Engine(engineSpeed, enginePower);

            int cargoWeight = Integer.parseInt(commandArgs[3]);
            String cargoType = commandArgs[4];
            Cargo cargo = new Cargo(cargoType, cargoWeight);

            List<Tire> tires = new ArrayList<>();

            for (int i = 5; i < commandArgs.length - 1; i+=2) {
                double pressure = Double.parseDouble(commandArgs[i]);
                int age = Integer.parseInt(commandArgs[i+1]);

                Tire tire = new Tire(pressure,age);

                tires.add(tire);
            }
            car = new Car(model, engine, cargo, tires);
            cars.add(car);

        }
        String command = scanner.nextLine();

        if(command.equals("fragile")){
            cars.stream()
                    .filter(car -> car.getTires()
                    .stream().filter(tire -> tire.getPressure() < 1).collect(Collectors.toList()).size() > 0)
                    .filter(car -> car.getCargo().getType().equals("fragile")).forEach(System.out::println);
        }else{
            cars.stream().filter(car -> "flamable".equals(car.getCargo().getType()))
                    .filter(car -> car.getEngine().getPower() > 250)
                    .forEach(System.out::println);
        }
    }
}
