package p02_StaticIdAndRate;

public class BankAccount {
    private static final double DEFAULT_INTEREST_RATE = 0.02;

    private static int accountsCount;

    private int id;

    private double balance;

    private static double currentInterestRate = DEFAULT_INTEREST_RATE;

    public BankAccount() {
        this.id = ++accountsCount;
    }

    public int getId() {
        return this.id;
    }

    public static void setInterestRate(double interestRate) {
        currentInterestRate = interestRate;
    }

    public void deposit(double amount) {
        this.balance += amount;
    }

    public double getInterestRate(int years) {
        return this.balance * currentInterestRate * years;
    }

    @Override
    public String toString() {
        return "ID" + this.id;
    }


}
