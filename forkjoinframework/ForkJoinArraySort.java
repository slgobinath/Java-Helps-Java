import java.util.Random;
import java.util.concurrent.*;

/**
 * Example of Merge Sort using Fork/Join framework.
 *
 * @author L.Gobinath
 */
public class ForkJoinArraySort {
    // From Java 7 '_' can be used to separate digits.
    public static final int ARRAY_SIZE = 10_000_000;

    public static void main(String[] args) {
        // Create a pool of threads
        ForkJoinPool pool = new ForkJoinPool();
        int[] array = createArray(ARRAY_SIZE);
        long startTime;
        long endTime;

        MergeSort mergeSort = new MergeSort(array, 0, array.length - 1);
        startTime = System.currentTimeMillis();

        pool.invoke(mergeSort); // Start execution and wait for result/return

        endTime = System.currentTimeMillis();
        System.out.println("Time taken: " + (endTime - startTime) + " millis");
    }

    /**
     * Create an array with random numbers.
     * @param  size Size of the array.
     * @return      An array with the given size.
     */
    private static int[] createArray(final int size) {
        int[] array = new int[size];
        Random rand = new Random();
        for (int i = 0; i < size; i++) {
            array[i] = rand.nextInt(1000);
        }
        return array;
    }
}

/**
 * Extends RecursiveAction.
 * Notice that the compute method does not return anything.
 */
class MergeSort extends RecursiveAction {
    private int array[];
    private int left;
    private int right;

    public MergeSort(int[] array, int left, int right) {
        this.array = array;
        this.left = left;
        this.right = right;
    }

    /**
     * Inherited from RecursiveAction.
     * Compare it with the run method of a Thread.
     */
    @Override
    protected void compute() {
        if (left < right) {
            int mid = (left + right) / 2;
            RecursiveAction leftSort = new MergeSort(array, left, mid);
            RecursiveAction rightSort = new MergeSort(array, mid + 1, right);
            invokeAll(leftSort, rightSort);
            merge(left, mid, right);
        }
    }

    /**
     * Merge two parts of an array in sorted manner.
     * @param left  Left side of left array.
     * @param mid   Middle of separation.
     * @param right Right side of right array.
     */
    private void merge(int left, int mid, int right) {
        int temp [] = new int[right - left + 1];
        int x = left;
        int y = mid + 1;
        int z = 0;
        while (x <= mid && y <= right) {
            if (array[x] <= array[y]) {
                temp[z] = array[x];
                z++;
                x++;
            } else {
                temp[z] = array[y];
                z++;
                y++;
            }
        }
        while (y <= right) {
            temp[z++] = array[y++];
        }
        while (x <= mid) {
            temp[z++] = array[x++];
        }

        for (z = 0; z < temp.length; z++) {
            array[left + z] = temp[z];
        }
    }
}