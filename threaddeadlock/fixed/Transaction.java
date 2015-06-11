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
        // Acquire the lock of Account 'from'
        synchronized (from) {
            from.withdraw(amount);
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) { }
        }
        // Release the lock of Account 'from'
        // Acquire the lock of Account 'to'
        synchronized (to) {
            to.deposit(amount);
        }
        // Release the lock of Account 'to'
        System.out.println(amount + "is transfered from " + from + " to " + to);
    }
}
