/**
 * All the variables declared in an interface are by default public, static and final.
 *
 * @author L.Gobinath
 */
public class InterfaceFields {
    public static void main(String[] args) {
        // Size.MIN_SIZE = 5;   // Compile time error
        System.out.println(Size.MIN_SIZE);
        System.out.println(Size.MAX_SIZE);
    }
}

interface Size {
    int MIN_SIZE = 1;
    public static final int MAX_SIZE = 10;
}