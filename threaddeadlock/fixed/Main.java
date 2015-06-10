public class Main {
	public static void main(String[] args) {
		final Account accA = new Account("Acc 1");
		final Account accB = new Account("Acc 2");
		accA.deposit(1000.00);
		accB.deposit(1000.00);

		Transaction t1 = new Transaction("T01", accA, accB, 100.00);
		Transaction t2 = new Transaction("T02", accB, accA, 500.00);

		t1.start();
		t2.start();
	}
}
