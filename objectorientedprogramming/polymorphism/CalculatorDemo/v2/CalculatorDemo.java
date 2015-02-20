/**
 * Sample Calculator class to demonstrate Method Overloading.
 *
 * @version 2.0
 * @author L.Gobinath
 */
public class CalculatorDemo {
    public static void main(String[] args) {
        Calculator calc = new Calculator();
        calc.add(10L, 30L);
        calc.add(10.5f, 0.5f);
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