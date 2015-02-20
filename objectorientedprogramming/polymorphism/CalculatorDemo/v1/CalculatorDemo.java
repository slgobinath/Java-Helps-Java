/**
 * Sample Calculator class to demonstrate Method Overloading.
 *
 * @version 1.0
 * @author L.Gobinath
 */
public class CalculatorDemo {
    public static void main(String[] args) {
        Calculator calc = new Calculator();
        calc.addLong(10L, 30L);
        calc.addFloat(10.5f, 0.5f);
    }
}

class Calculator {
    public void addLong(long x, long y) {
        long result = x + y;
        System.out.println("Long addition: " + result);
    }

    public void addFloat(float x, float y) {
        float result = x + y;
        System.out.println("Float addition: " + result);
    }
}