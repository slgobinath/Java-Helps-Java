public class Account {
    private final String name;
    private double balance;

    public Account(String name) {
        this.name = name;
    }

    public void withdraw(double amount) {
        this.balance -= amount;
    }

    public void deposit(double amount) {
        this.balance += amount;
    }

    public double getBalance() {
        return this.balance;
    }

    @Override
    public String toString() {
        return name;
    }
}
