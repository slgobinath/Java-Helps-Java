public abstract class Square implements Shape {
    private double width;

    public Square(double width) {
        this.width = width;
    }

    @Override
    public void draw() {
        System.out.println("Create a square with width: " + width);
    }
}