/**
* Modifying String object creates Garbage objects.
* It is not recommended to modify a String object so many times.
* This code is an example of bad practice in Java.
*
* @author L.Gobinath
*/
public class GarbageGenerator {
    public static void main(String[] args) {
        String result = "";

        for (int i = 0; i < 10; i++) {
            // Every time creates a new object
            result += i;
        }
        System.out.println(result);
    }
}