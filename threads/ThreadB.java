/**
 * Sample thread class by implementing java.lang.Runnable.
 *
 * @author L.Gobinath
 */
public class ThreadB implements Runnable {
	@Override
	public void run() {
		for(int i = 0; i < 1000; i++) {
			System.out.println("Thread B: " + i);
		}
	}
}