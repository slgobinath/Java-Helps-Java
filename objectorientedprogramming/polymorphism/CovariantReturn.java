/**
 * Covariant return example.
 * Overriding method returns a subtype of overridden method's return type.
 *
 * @version 1.0
 * @author L.Gobinath
 */
public class CovariantReturn {
    public static void main(String[] args) {
        create(new CircleFactory());
    }

    public static void create(ShapeFactory factory) {
        Shape shape = factory.getShape();
        // Circle circle = factory.getShape();  // Compile time error
        shape.draw();   // Circle
    }
}

class Shape {
    public void draw() {
        System.out.println("Shape");
    }
}
class Circle extends Shape {
    public void draw() {
        System.out.println("Circle");
    }
}

class ShapeFactory {
    public Shape getShape() {
        return new Shape();
    }
}

class CircleFactory extends ShapeFactory {
    public Circle getShape() {
        return new Circle();
    }
}