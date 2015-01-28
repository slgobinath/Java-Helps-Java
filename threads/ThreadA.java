/**
 * Sample thread class by extending java.lang.Thread.
 *
 * @author L.Gobinath
 */
public class ThreadA extends Thread {
	@Override
	public void run() {
		for(int i = 0; i < 1000; i++) {
			System.out.println("Thread A: " + i);
		}
	}
}