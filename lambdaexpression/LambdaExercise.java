import java.util.*;

public class LambdaExercise {
	public static void main(String[] args) {
		String[] array = {"Java", "C++", "Ruby", "Python"};
		System.out.println("Unsorted: " + Arrays.toString(array));
		Arrays.sort(array, (x, y) -> y.compareTo(x));
		System.out.println("Reverse sorted: " + Arrays.toString(array));
	}
}