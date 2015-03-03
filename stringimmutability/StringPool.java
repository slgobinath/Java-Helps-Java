/**
* Same "Java" object is shared by both references.
*
* @author L.Gobinath
*/
public class StringPool {
    public static void main(String[] args) {
        String x = "Java";
        String y = "Java";

        System.out.println(x == y); //true
        System.out.println(x.toLowerCase());    // java
        System.out.println(x);  // Java
        System.out.println(y);  // Java
        x = x.toLowerCase();    // Update the reference
        System.out.println(x);  // java
        System.out.println(y);  // Java
    }
}