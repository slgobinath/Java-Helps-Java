/**
* Modifying String object creates Garbage objects.
* Java recommends to use either StringBuffer or StringBuilder.
*
* @author L.Gobinath
*/
public class BestPractice {
    public static void main(String[] args) {
        StringBuilder builder = new StringBuilder();

        for (int i = 0; i < 10; i++) {
            builder.append(i);
        }
        String result = builder.toString();
        System.out.println(result);
    }
}