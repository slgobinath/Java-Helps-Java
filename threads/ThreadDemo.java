/**
 * Sample test class to start Threads.
 *
 * @author L.Gobinath
 */
public class ThreadDemo {
	public static void main(String[] args) {
		// Create thread objects
		Thread threadA = new ThreadA();	// Thread object
		Runnable runnable = new ThreadB(); // Runnable object
		Thread threadB = new Thread(runnable); // Helper thread object

		// Start the threads
		threadA.start();
		threadB.start();
	}
}