import java.util.Random;
import java.util.concurrent.*;

/**
 * Count the number of occurences of a number in an array using Fork/Join framework.
 * 
 * @author L.Gobinath
 */
public class SearchArray {
    public static void main(String[] args) {
        int[] array = {5, 6, 3, 2, 8, 1, 5, 5, 3, 9, 7, 5, 2, 4};
        // Search for 5
        Counter counter = new Counter(5, array, 0, array.length - 1);
        // Create a pool of threads
        ForkJoinPool pool = new ForkJoinPool();
        // Start execution and wait for result
        int count = pool.invoke(counter);
        System.out.println("Count: " + count);	// Count: 4
    }
}

class Counter extends RecursiveTask<Integer> {
    // The number to search
    private int num;
    private int[] array;
    private int left;
    private int right;

    public Counter(int num, int[] array, int left, int right) {
        this.num = num;
        this.array = array;
        this.left = left;
        this.right = right;
    }

    /**
     * Inherited from RecursiveAction.
     * Compare it with the run method of a Thread.
     */
    @Override
    public Integer compute() {
        if (left == right) {
            // Check the number
            if (array[left] == num) {
                return 1;
            }
        } else if (left < right) {
            int mid = (left + right) / 2;
            // Create sub tasks
            RecursiveTask<Integer> leftTask = new Counter(num, array, left, mid);
            RecursiveTask<Integer> rightTask = new Counter(num, array, mid + 1, right);

            // Execute the sub tasks
            leftTask.fork();
            rightTask.fork();

            int count = 0;
            // Wait and recieve the outputs from sub tasks
            count += leftTask.join();
            count += rightTask.join();

            return count;
        }
        return 0;
    }
}