public class Main {
    public static void main(String[] args) {
        Shape circle = new SolidColorCircle(7.0, "RED");
        Shape square = new GradientSquare(10, "BLUE", "GREEN");
        circle.draw();
        square.draw();
    }
}