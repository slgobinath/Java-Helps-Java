public class GradientSquare extends Square {
    private String colorX;
    private String colorY;

    public GradientSquare(double width, String colorX, String colorY) {
        super(width);
        this.colorX = colorX;
        this.colorY = colorY;
    }

    @Override
    public void draw() {
        super.draw();
        System.out.println("Fill with: " + colorX + " & " + colorY);
    }
}