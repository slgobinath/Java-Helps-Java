/**
 * CurrentAccount allows to have negative balance.
 *
 * @version 2.0
 * @author L.Gobinath
 */
public class CurrentAccount extends BankAccount {
	/**
	 * Overriding method.
	 */
	public boolean withdraw(double amount) {
		balance -= amount;
		return true;
	}
}