/**
 * Sample class BankAccount which is used as the super class of CurrentAcoount and SavingsAccount.
 *
 * @version 1.0
 * @author L.Gobinath
 */
public class BankAccount {
    private String name;
    protected double balance;

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void deposite(double amount) {
    	this.balance += amount;
    }
    
    public boolean withdraw(double amount) {
        if (balance > amount) {
            balance -= amount;
            return true;
        } else {
            return false;
        }
    }
}