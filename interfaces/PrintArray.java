import java.util.StringJoiner;

/**
 * Example utility interface with a static method.
 * You need Java 8 to compile and run this code.
 * Static methods in interfaces are introduced in Java 8.
 * The StringJoiner class also introduced in Java 8 to join Strings efficiently.
 *
 * @author L.Gobinath
 */
public class PrintArray {
    public static void main(String[] args) {
        String[] arr = {"Java", "C++", "C", "Python", "PHP"};
        Printer.print(arr);
    }
}

interface Printer {
    public static void print(String[] array) {
        StringJoiner joiner = new StringJoiner(", ", "[", "]");
        for (String str : array) {
            joiner.add(str);
        }
        System.out.println(joiner.toString());
    }
}