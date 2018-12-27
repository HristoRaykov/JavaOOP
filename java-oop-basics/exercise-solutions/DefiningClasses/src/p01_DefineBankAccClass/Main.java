package p01_DefineBankAccClass;

import java.util.HashMap;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        HashMap<Integer, BankAccount> accounts = new HashMap<>();

        String input = scanner.nextLine();

        while(!input.equals("End")){
            String[] commandArgs = input.split(" ");

            switch (commandArgs[0]){
                case "Create":
                    executeCreateCommand(accounts, commandArgs[1]);
                    break;
                case "Deposit":
                    executeDepositCommand(accounts, commandArgs);
                    break;
                case "Withdraw":
                    executeWithdrawCommand(accounts, commandArgs);
                    break;
                case "Print":
                    executePrintCommand(accounts, commandArgs[1]);
                    break;
            }

            input = scanner.nextLine();
        }
    }

    private static void executePrintCommand(HashMap<Integer, BankAccount> accounts, String commandArg) {
        int id = Integer.valueOf(commandArg);

        if(!accounts.containsKey(id)){
            System.out.println("Account does not exist");
        }else{
            BankAccount account = accounts.get(id);
            System.out.printf("Account %s, balance %.2f%n", account, account.getBalance());
        }
    }

    private static void executeWithdrawCommand(HashMap<Integer, BankAccount> accounts, String[] commandArgs) {
        int id = Integer.valueOf(commandArgs[1]);
        double amount = Double.valueOf(commandArgs[2]);

        if(!accounts.containsKey(id)){
            System.out.println("Account does not exist");
            return;
        }
        try{
            accounts.get(id).withdraw(amount);
        }catch(IllegalStateException ise){
            System.out.println(ise.getMessage());
        }
    }

    private static void executeDepositCommand(HashMap<Integer, BankAccount> accounts, String[] commandArgs) {
        int id = Integer.valueOf(commandArgs[1]);
        double amount = Double.valueOf(commandArgs[2]);

        try{
            accounts.get(id).deposit(amount);
        }catch(Exception ex){
            System.out.println("Account does not exist");
        }
    }

    private static void executeCreateCommand(HashMap<Integer, BankAccount> accounts, String commandArg) {
        int id = Integer.valueOf(commandArg);
        if(!accounts.containsKey(id)){
            BankAccount account = new BankAccount();
            account.setId(id);
            accounts.put(id, account);
        }else{
            System.out.println("Account already exists");
        }
    }
}
