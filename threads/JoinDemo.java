/**
 * In this sample project, Painter is waiting for Mason.
 * Until mason completes his task, the painter cannot start his job.
 * 
 * @author L.Gobinath
 */
public class JoinDemo {
    public static void main(String[] args) {
    	Thread mason = new Thread(new Mason());
    	Thread painter = new Thread(new Painter(mason));
    	mason.start();
    	painter.start();
    }
}

class Mason implements Runnable {
    @Override
    public void run() {
    	System.out.println("Start building.");
        for (int i = 0; i < 5; i++) {
            System.out.println("Building a house...");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException ex) {}
        }
        System.out.println("Finish building.");
    }
}

class Painter implements Runnable {
    private Thread mason;

    public Painter(Thread mason) {
        this.mason = mason;
    }

    @Override
    public void run() {
    	System.out.println("Wait for mason.");
    	// Join this thread after the mason thread.
        try {
            this.mason.join();
        } catch (InterruptedException ex) {}
        System.out.println("Start painting.");
        for (int i = 0; i < 5; i++) {
            System.out.println("Painting the house...");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException ex) {}
        }
        System.out.println("Finish painting.");
    }
}