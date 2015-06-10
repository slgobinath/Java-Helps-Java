public class Transaction extends Thread {
	private final String id;
	private final Account from;
	private final Account to;
	private final double amount;

	public Transaction(String id, Account from, Account to, double amount) {
		this.id = id;
		this.from = from;
		this.to = to;
		this.amount = amount;
	}

	@Override
	public void run() {
		synchronized (from) {
			from.withdraw(amount);
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
			}
			synchronized (to) {
				to.deposit(amount);
			}
		}
		System.out.println(from + " is released by " + id);
		System.out.println(amount + "is transfered from " + from + " to " + to);
	}
}
