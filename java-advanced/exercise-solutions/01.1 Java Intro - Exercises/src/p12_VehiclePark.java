import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class p12_VehiclePark {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] carsInput = scanner.nextLine().split(" ");

        ArrayList<String> cars = new ArrayList<>();

        cars.addAll(Arrays.asList(carsInput));

        int[] count = new int[1];

        while (true) {
            String[] input = scanner.nextLine().toLowerCase().split(" ");

            String vehicle = input[0];

            if ("end".equals(vehicle)) {
                break;
            }
            int seats = Integer.parseInt(input[2]);

            vehiclesProcess(cars, vehicle, seats, count);
        }
        System.out.println("Vehicles left: " + cars.toString().replace("[", "").replace("]", ""));
        System.out.printf("Vehicles sold: %d", count[0]);
    }
    public static void vehiclesProcess(ArrayList<String> cars, String vehicle, int seats, int[] count) {

        String match = "" + vehicle.charAt(0) + seats;

        for (int i = 0; i < cars.size(); i++) {
            if (match.equals(cars.get(i))) {

                int price = cars.get(i).charAt(0) * seats;
                count[0]++;
                cars.remove(i);

                System.out.printf("Yes, sold for %d$\n", price);
                return;
            }
        }
        System.out.println("No");
    }
}
