package P07_CarSalesman;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(reader.readLine());

        List<Engine> engineList = new ArrayList<>();
        readEngines(reader, n, engineList);

        n = Integer.parseInt(reader.readLine());

        LinkedList<Car> carList = new LinkedList<>();
        readCars(reader, n, engineList, carList);

        carList.forEach(System.out::print);
    }

    private static void readCars(BufferedReader reader, int n, List<Engine> engineList, LinkedList<Car> carList) throws IOException {
        while (n-- > 0) {
            String[] input = reader.readLine().split(" ");

            String model = input[0];
            String engineType = input[1];
            String weight = "";
            String color = "";

            switch (input.length) {
                case 4: {
                    weight = input[2];
                    color = input[3];
                    break;
                }
                case 3:
                    try {
                        weight = String.valueOf(Integer.parseInt(input[2]));
                    } catch (Exception ex) {
                        color = input[2];
                    }
                    break;
            }
            if(weight.equals("")){
                weight = "n/a";
            }
            if(color.equals("")){
                color = "n/a";
            }
            Car car = null;
            for (Engine engine : engineList) {
                if (engine.getModel().equals(engineType)) {
                    car = new Car(model, engine, weight, color);
                    break;
                }
            }
            carList.add(car);
        }
    }

    private static void readEngines(BufferedReader reader, int n, List<Engine> engineList) throws IOException {
        while (n-- > 0) {
            String[] input = reader.readLine().split(" ");

            String model = input[0];
            int power = Integer.parseInt(input[1]);
            String displacement = "";
            String efficiency = "";

            Engine engine = null;
            switch (input.length) {
                case 4:
                    displacement = input[2];
                    efficiency = input[3];
                    break;
                case 3:
                    try {
                        displacement = String.valueOf(Integer.parseInt(input[2]));
                    } catch (Exception ex) {
                        efficiency = input[2];
                    }
                    break;
            }
            if(displacement.equals("")){
                displacement = "n/a";
            }
            if(efficiency.equals("")){
                efficiency = "n/a";
            }
            engine = new Engine(model, power, displacement, efficiency);
            engineList.add(engine);
        }
    }
}
