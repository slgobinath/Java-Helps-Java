public class SolidColorSquare extends Square {
    private String color;

    public SolidColorSquare(double width, String color) {
        super(width);
        this.color = color;
    }

    @Override
    public void draw() {
        super.draw();
        System.out.println("Fill with: " + color);
    }
}