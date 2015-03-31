public class Square implements Shape {
    private double width;
    private Background background;

    public Square(double width, Background background) {
        this.width = width;
        this.background = background;
    }

    @Override
    public void draw() {
        System.out.println("Create a square with width: " + width);
        background.fill();
    }
}