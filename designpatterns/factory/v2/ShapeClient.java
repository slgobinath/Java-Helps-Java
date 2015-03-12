import com.javahelps.shapes.*;

public class ShapeClient {
    public static void main(String[] args) {
        ShapeFactory factory = new ShapeFactory();
        Shape circle = factory.createShape(ShapeFactory.Type.CIRCLE);
        Shape square = factory.createShape(ShapeFactory.Type.SQUARE);
        Shape rectangle = factory.createShape(ShapeFactory.Type.RECTANGLE);
        circle.draw();
        square.draw();
        rectangle.draw();
    }
}