/**
 * Testing class for BankAccounts.
 *
 * @version 1.0
 * @author L.Gobinath
 */
public class BankDemo {
    public static void main(String[] args) {
        CurrentAccount c = new CurrentAccount();
        SavingsAccount s = new SavingsAccount();
        c.deposite(500.00);
        s.deposite(500.00);
        doWithdrawal(c);    // Withdraw succeed.
        doWithdrawal(s);    // Withdraw failed.
    }

    public static void doWithdrawal(BankAccount acc) {
        boolean result = acc.withdraw(1000.00);
        if (result) {
            System.out.println("Withdraw succeed.");
        } else {
            System.out.println("Withdraw failed.");
        }
    }
}