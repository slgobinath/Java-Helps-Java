import java.util.Random;
import com.javahelps.shapes.*;

public class ShapeClient {
    public static void main(String[] args) {
        Random random = new Random();
        Shape circle = new Circle(random.nextInt());
        Shape square = new Square(random.nextInt());
        Shape rectangle = new Rectangle(random.nextInt(), random.nextInt());
        circle.draw();
        square.draw();
        rectangle.draw();
    }
}