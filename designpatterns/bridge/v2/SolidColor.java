public class SolidColor implements Background {
    private String color;

    public SolidColor(String color) {
        this.color = color;
    }

    @Override
    public void fill() {
        System.out.println("Fill with: " + color);
    }
}