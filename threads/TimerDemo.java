/**
 * This class demonstrates a Timer which prints 'Hello world!' for every 2 seconds.
 * To terminate the application press Ctrl + C.
 *
 * @author L.Gobinath
 */
public class TimerDemo {
	public static void main(String[] args) {
		Runnable timer = new Timer();
		Thread thread = new Thread(timer);
		thread.start();
	}
}

class Timer implements Runnable {
	private final long INTERVAL = 2000;	// 2 seconds
	@Override
	public void run() {
		while(true) {
			// Print the message
			System.out.println("Hello world!");
			// Sleep for 2 seconds
			try {
				Thread.sleep(INTERVAL);
			} catch(InterruptedException ex) {}
		}
	}
}