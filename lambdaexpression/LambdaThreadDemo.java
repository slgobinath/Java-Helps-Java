public class LambdaThreadDemo {
	public static void main(String[] args) {
		// Runnable anonymous object
		Runnable runnable = () -> System.out.println("ID: " + Thread.currentThread().getId());
		Thread thread = new Thread(runnable);
		thread.start();
	}
}