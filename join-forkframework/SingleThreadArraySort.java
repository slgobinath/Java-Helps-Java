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
        int i = left;
        int j = mid + 1;
        int k = 0;
        while (i <= mid && j <= right) {
            if (array[i] <= array[j]) {
                temp[k] = array[i];
                k++;
                i++;
            } else {
                temp[k] = array[j];
                k++;
                j++;
            }
        }
        while (j <= right) {
            temp[k++] = array[j++];
        }
        while (i <= mid) {
            temp[k++] = array[i++];
        }

        for (k = 0; k < temp.length; k++) {
            array[left + k] = temp[k];
        }
    }
}