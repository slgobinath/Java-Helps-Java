import java.util.Arrays;
import java.util.Random;

/**
 * Example of ordinary Merge Sort.
 * Sorting is done by the main thread itself.
 *
 * @author L.Gobinath
 */
public class SingleThreadArraySort {
    // From Java 7 '_' can be used to separate digits.
    public static final int ARRAY_SIZE = 10_000_000;

    public static void main(String[] args) {
        long startTime;
        long endTime;
        int[] array = createArray(ARRAY_SIZE);
        MergeSort mergeSort = new MergeSort(array);

        startTime = System.currentTimeMillis(); // Get the current time before sorting
        mergeSort.sort();
        endTime = System.currentTimeMillis();   // Get the current time after sorting
        
        System.out.println("Time taken: " + (endTime - startTime) + " millis");
    }
    /**
     * Create an array with random integers.
     * @param  size The expected size of the array
     * @return      The array with given size
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

class MergeSort {
    private int array[];

    public MergeSort(int[] array) {
        this.array = array;
    }

    public void sort() {
        sort(0, array.length - 1);
    }

    /**
     * Sort the array within given range using divide and conquer algorithm.
     * @param left  The lower limit of range
     * @param right The upper limit of range
     */
    private void sort(int left, int right) {
        if (left < right) {
            int mid = (left + right) / 2;
            sort(left, mid);
            sort(mid + 1, right);
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