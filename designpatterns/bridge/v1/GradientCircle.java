public class GradientCircle extends Circle {
    private String colorX;
    private String colorY;

    public SolidColorCircle(double radius, String colorX, String colorY) {
        super(radius);
        this.colorX = colorX;
        this.colorY = colorY;
    }

    @Override
    public void draw() {
        super.draw();
        System.out.println("Fill with: " + colorX + " & " + colorY);
    }
}