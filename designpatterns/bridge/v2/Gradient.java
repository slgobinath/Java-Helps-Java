public class Gradient implements Background {
    private String colorX;
    private String colorY;

    public Gradient(String colorX, String colorY) {
        this.colorX = colorX;
        this.colorY = colorY;
    }

    @Override
    public void fill() {
        System.out.println("Fill with: " + colorX + " & " + colorY);
    }
}