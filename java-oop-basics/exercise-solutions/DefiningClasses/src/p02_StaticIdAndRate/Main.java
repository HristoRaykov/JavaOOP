package p02_StaticIdAndRate;

import java.util.HashMap;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        HashMap<Integer, BankAccount> accounts = new HashMap<>();

        String input = scanner.nextLine();

        while (!input.equals("End")) {
            String[] commandArgs = input.split(" ");

            switch (commandArgs[0]) {
                case "Create":
                    BankAccount account = new BankAccount();
                    accounts.put(account.getId(), account);
                    System.out.printf("Account %s created%n", account);
                    break;
                case "Deposit":
                    try {
                        accounts.get(Integer.valueOf(commandArgs[1])).deposit(Double.valueOf(commandArgs[2]));
                        System.out.printf("Deposited %.0f to ID%s%n",Double.valueOf(commandArgs[2]), Integer.valueOf(commandArgs[1]) );
                    }catch (Exception ex){
                        System.out.println("Account does not exist");
                    }
                    break;
                case "SetInterest":
                    BankAccount.setInterestRate(Double.valueOf(commandArgs[1]));
                    break;
                case "GetInterest":
                    try {
                        System.out.printf("%.2f%n", accounts.get(Integer.valueOf(commandArgs[1])).
                                getInterestRate(Integer.valueOf(commandArgs[2])));
                    }catch (Exception ex){
                        System.out.println("Account does not exist");
                    }
                    break;
            }
            input = scanner.nextLine();
        }
    }
}
