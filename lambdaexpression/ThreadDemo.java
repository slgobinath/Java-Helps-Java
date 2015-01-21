public class ThreadDemo {
	public static void main(String[] args) {
		// Runnable anonymous object
		Runnable runnable = new Runnable() {
			@Override
			public void run() {
				System.out.println("ID: " + Thread.currentThread().getId());
			}
		};
		Thread thread = new Thread(runnable);
		thread.start();
	}
}