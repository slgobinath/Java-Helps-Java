public class ConcurrencyProblem {
    static int[] array = {0};

    public static void main(String[] args) throws InterruptedException {
        Thread a = new Thread() {
            public void run() {
                for (int i = 1; i <= 1000; i++) {
                    increase();
                }
            }
        };

        Thread b = new Thread() {
            public void run() {
                for (int i = 1; i <= 1000; i++) {
                    decrease();
                }
            }
        };

        a.start();
        b.start();
        a.join();
        b.join();
        System.out.println(array[0]);
    }

    public static void increase() {
        // Do something else
        synchronized (array) {
            array[0]++;
        }
        // Do something else
    }

    public static void decrease() {
        // Do something else
        synchronized (array) {
            array[0]--;
        }
        // Do something else
    }
}