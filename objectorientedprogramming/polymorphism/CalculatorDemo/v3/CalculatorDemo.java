/**
 * Sample Calculator class to demonstrate Method Overloading.
 *
 * @version 3.0
 * @author L.Gobinath
 */
public class CalculatorDemo {
    public static void main(String[] args) {
        Calculator calc = new Calculator();
        // Passing two integer values
        calc.add(10, 30);   // add(long, long)
        // Passing two long values
        calc.add(10L, 30L); // add(long, long)
    }
}

/**
 * Calculator class has two methods add(long, long) and add(float, float).
 */
class Calculator {
    public void add(long x, long y) {
        long result = x + y;
        System.out.println("Long addition: " + result);
    }

    public void add(float x, float y) {
        float result = x + y;
        System.out.println("Float addition: " + result);
    }
}