public class Circle implements Shape {
    private double radius;
    private Background background;

    public Circle(double radius, Background background) {
        this.radius = radius;
        this.background = background;
    }

    @Override
    public void draw() {
        System.out.println("Create a circle with radius: " + radius);
        background.fill();
    }
}