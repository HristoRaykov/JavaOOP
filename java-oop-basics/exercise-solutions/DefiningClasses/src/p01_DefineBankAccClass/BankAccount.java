package p01_DefineBankAccClass;

public class BankAccount {

    private int id;

    private double balance;

    public void setId(int id) {
        this.id = id;
    }

    public double getBalance() {
        return this.balance;
    }

    public void deposit(double amount) {
        this.balance += amount;

    }

    public void withdraw(double amount) {
        if (amount > this.balance) {
            throw new IllegalStateException("Insufficient balance");
        }
        this.balance -= amount;
    }

    @Override
    public String toString() {
        return "ID" + this.id;
    }
}
