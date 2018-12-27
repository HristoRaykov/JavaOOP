import java.util.HashSet;
import java.util.Scanner;

public class p01_ParkingLot {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        HashSet<String> parking = new HashSet<>();

        while(true){
            String[] input = scanner.nextLine().split(", ");

            if("END".equals(input[0])){
                break;
            }

            String command = input[0];
            String plate = input[1];

            if(command.equals("IN")){
                parking.add(plate);
            }else if(command.equals("OUT")){
                parking.remove(plate);
            }
        }

        if(parking.size() == 0){
            System.out.println("Parking Lot is Empty");
        }else {

            for (String s : parking) {
                System.out.println(s);
            }
        }
    }
}
