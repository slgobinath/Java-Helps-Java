public class Main {
    public static void main(String[] args) {
        Shape circle = new Circle(7.0, new SolidColor("RED"));
        Shape square = new Square(10.0, new Gradient("BLUE", "GREEN"));
        circle.draw();
        square.draw();
    }
}