public class SolidColorCircle extends Circle {
    private String color;

    public SolidColorCircle(double radius, String color) {
        super(radius);
        this.color = color;
    }

    @Override
    public void draw() {
        super.draw();
        System.out.println("Fill with: " + color);
    }
}