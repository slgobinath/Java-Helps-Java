/**
 * Sample Calculator class to demonstrate Method Overloading.
 *
 * @version 4.0
 * @author L.Gobinath
 */
public class CalculatorDemo {
    public static void main(String[] args) {
        Calculator calc = new Calculator();
        // Passing two integer values
        calc.add(10, 30);   // add(int, int)
        // Passing two long values
        calc.add(10L, 30L); // add(long, long)
    }
}

/**
 * Calculator class has two methods add(long, long) and add(int, int).
 */
class Calculator {
    public void add(long x, long y) {
        long result = x + y;
        System.out.println("Long addition: " + result);
    }

    public void add(int x, int y) {
        int result = x + y;
        System.out.println("Integer addition: " + result);
    }
}